import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] distances, prevNode;
  static Map<Integer, List<Node>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int start = 1; start < n + 1; start++) {
      dijkstra(start);
      for (int dest = 1; dest < n + 1; dest++) {
        if (start == dest) {
          sb.append("-");
        } else {
          sb.append(findAnswer(start, dest));
        }
        sb.append(" ");
      }
      sb.append("\n");
    }

    output();
  }

  private static int findAnswer(int start, int dest) {
    while (prevNode[start][dest] != start) {
      dest = prevNode[start][dest];
    }
    return dest;
  }

  private static void dijkstra(int start) {
    distances[start][start] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      if (distances[start][node.dest] < node.dist) {
        continue;
      }

      for (Node next : graph.get(node.dest)) {
        int total = next.dist + node.dist;
        if (total < distances[start][next.dest]) {
          distances[start][next.dest] = total;
          prevNode[start][next.dest] = node.dest;
          pq.add(new Node(next.dest, total));
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    for (int i = 0; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }
    distances = new int[n + 1][n + 1];
    prevNode = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
      Arrays.fill(prevNode[i], -1);
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    public int dest;
    public int dist;

    public Node(int dest, int dist) {
      this.dest = dest;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
      return this.dist - other.dist;
    }
  }
}