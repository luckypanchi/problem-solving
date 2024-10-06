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
  static int v, e, p;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] fromStart = dijkstra(1);
    int[] fromGeonwoo = dijkstra(p);

    if (fromStart[v] == fromStart[p] + fromGeonwoo[v]) {
      sb.append("SAVE HIM");
    } else {
      sb.append("GOOD BYE");
    }

    output();
  }

  private static int[] dijkstra(int start) {
    int[] distances = new int[v + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();

    distances[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.prevCost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextCost = next[1] + curr.prevCost;
        if (nextCost < distances[next[0]]) {
          distances[next[0]] = nextCost;
          pq.add(new Node(next[0], nextCost));
        }
      }
    }

    return distances;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.putIfAbsent(a, new ArrayList<>());
      graph.putIfAbsent(b, new ArrayList<>());
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int nodeNumber, prevCost;

    public Node(int nodeNumber, int prevCost) {
      this.nodeNumber = nodeNumber;
      this.prevCost = prevCost;
    }

    @Override
    public int compareTo(Node o) {
      return this.prevCost - o.prevCost;
    }

  }

}