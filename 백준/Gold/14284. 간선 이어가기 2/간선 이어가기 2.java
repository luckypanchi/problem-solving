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
  static int n, m, s, t;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dijkstra());

    output();
  }

  private static int dijkstra() {
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();

    distances[s] = 0;
    pq.offer(new Node(0, s));

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (curr.number == t) {
        break;
      }

      if (distances[curr.number] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.number)) {
        int nextCost = next[1] + curr.cost;
        if (nextCost < distances[next[0]]) {
          distances[next[0]] = nextCost;
          pq.offer(new Node(nextCost, next[0]));
        }
      }
    }

    return distances[t];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.putIfAbsent(a, new ArrayList<>());
      graph.putIfAbsent(b, new ArrayList<>());
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }
    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int cost, number;

    public Node(int cost, int number) {
      this.cost = cost;
      this.number = number;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }

}