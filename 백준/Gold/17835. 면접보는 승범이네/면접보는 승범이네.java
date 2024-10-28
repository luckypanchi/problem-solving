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
  static int n, m, k;
  static Map<Integer, List<int[]>> graph;
  static int[] starts;

  public static void main(String[] args) throws IOException {
    setUp();

    long[] distances = dijkstra();
    long maxDist = Long.MIN_VALUE;
    int cityNumber = -1;
    for (int i = 1; i < n + 1; i++) {
      if (maxDist < distances[i]) {
        maxDist = distances[i];
        cityNumber = i;
      }
    }

    sb.append(cityNumber).append("\n").append(maxDist);

    output();
  }

  private static long[] dijkstra() {
    long[] distances = new long[n + 1];
    Arrays.fill(distances, Long.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));

    for (int start : starts) {
      distances[start] = 0;
      pq.offer(new Pair(start, 0));
    }

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int nextCost = next[1];
        long totalCost = curr.cost + nextCost;

        if (totalCost < distances[nextNodeNumber]) {
          distances[nextNodeNumber] = totalCost;
          pq.offer(new Pair(nextNodeNumber, totalCost));
        }
      }
    }

    return distances;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    starts = new int[k];
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(v).add(new int[]{u, c});
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      starts[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int nodeNumber;
    long cost;

    public Pair(int nodeNumber, long cost) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
    }
  }

}