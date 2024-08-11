import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static Map<Integer, List<Pair>> graph;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dijkstra();

    long answer = Long.MAX_VALUE;
    for (long d : dp[n]) {
      answer = Math.min(answer, d);
    }

    sb.append(answer);

    output();
  }

  private static void dijkstra() {
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.dist));
    pq.offer(new Pair(1, 0, 0));
    dp[1][0] = 0;

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (dp[curr.node][curr.count] < curr.dist) {
        continue;
      }

      for (Pair next : graph.get(curr.node)) {
        long totalCost = next.dist + curr.dist;
        if (totalCost < dp[next.node][curr.count]) {
          dp[next.node][curr.count] = totalCost;
          pq.offer(new Pair(next.node, curr.count, totalCost));
        }
        if (curr.count < k && curr.dist < dp[next.node][curr.count + 1]) {
          dp[next.node][curr.count + 1] = curr.dist;
          pq.offer(new Pair(next.node, curr.count + 1, curr.dist));
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    dp = new long[n + 1][k + 1];
    for (int i = 0; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
      Arrays.fill(dp[i], Long.MAX_VALUE);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Pair(b, 0, c));
      graph.get(b).add(new Pair(a, 0, c));
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int node, count;
    long dist;

    public Pair(int node, int count, long dist) {
      this.node = node;
      this.count = count;
      this.dist = dist;
    }
  }
}