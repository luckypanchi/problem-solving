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
  static int n, m, d, e;
  static int[] heights;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    long[] startFromHome = dijkstra(1);
    long[] startFromKorea = dijkstra(n);

    long answer = Long.MIN_VALUE;
    for (int top = 2; top < n; top++) {
      if (startFromHome[top] == Long.MAX_VALUE || startFromKorea[top] == Long.MAX_VALUE) {
        continue;
      }
      long result = (long) heights[top] * e - (startFromHome[top] + startFromKorea[top]) * d;
      answer = Math.max(answer, result);
    }

    if (answer == Long.MIN_VALUE) {
      sb.append("Impossible");
    } else {
      sb.append(answer);
    }

    output();
  }

  private static long[] dijkstra(int start) {
    long[] distances = new long[n + 1];
    Arrays.fill(distances, Long.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));

    distances[start] = 0;
    pq.offer(new Pair(start, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int cost = next[1];
        long totalCost = curr.cost + cost;

        if (totalCost < distances[nextNodeNumber] && heights[curr.nodeNumber] < heights[nextNodeNumber]) {
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
    d = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    heights = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, n});
      graph.get(b).add(new int[]{a, n});
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