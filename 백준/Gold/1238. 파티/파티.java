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
  static int n, m, x;
  static Map<Integer, List<Edge>> map;
  static int[][] distances;

  static final int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < n + 1; i++) {
      dijkstra(i, distances[i]);
    }

    int answer = -1;
    for (int start = 1; start < n + 1; start++) {
      answer = Math.max(answer, distances[start][x] + distances[x][start]);
    }

    sb.append(answer);
    output();
  }

  private static void dijkstra(int start, int[] distance) {
    distance[start] = 0;

    PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> o1.totalWeight - o2.totalWeight);
    heap.add(new Pair(start, distance[start]));

    while (!heap.isEmpty()) {
      Pair curr = heap.poll();

      if (distance[curr.node] < curr.totalWeight) {
        continue;
      }

      for (Edge edge : map.get(curr.node)) {
        int totalWeight = edge.weight + curr.totalWeight;
        if (totalWeight < distance[edge.dest]) {
          distance[edge.dest] = totalWeight;
          heap.add(new Pair(edge.dest, totalWeight));
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    distances = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(distances[i], MAX);
    }

    map = new HashMap<>();
    for (int i = 0; i < n + 1; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      map.get(u).add(new Edge(v, w));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int node;
    int totalWeight;

    public Pair(int node, int totalWeight) {
      this.node = node;
      this.totalWeight = totalWeight;
    }
  }

  private static class Edge {

    int dest;
    int weight;

    public Edge(int dest, int weight) {
      this.dest = dest;
      this.weight = weight;
    }
  }

}