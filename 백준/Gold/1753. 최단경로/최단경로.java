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
  static int v, e;
  static int start;
  static Map<Integer, List<Edge>> map;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] distances = dijkstra();

    for (int i = 1; i < v + 1; i++) {
      sb.append(distances[i] != Integer.MAX_VALUE ? distances[i] : "INF").append("\n");
    }

    output();
  }

  private static int[] dijkstra() {
    int[] distances = new int[v + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[start] = 0;

    PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> o1.totalWeight - o2.totalWeight);
    heap.add(new Pair(start, distances[start]));

    while (!heap.isEmpty()) {
      Pair curr = heap.poll();

      if (distances[curr.node] < curr.totalWeight) {
        continue;
      }

      for (Edge next : map.get(curr.node)) {
        int totalWeight = curr.totalWeight + next.weight;
        if (totalWeight < distances[next.dest]) {
          distances[next.dest] = totalWeight;
          heap.add(new Pair(next.dest, totalWeight));
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
    start = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    for (int i = 0; i < v + 1; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
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