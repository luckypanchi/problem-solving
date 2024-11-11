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
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dijkstra());

    output();
  }

  private static long dijkstra() {
    long[] distances = new long[n + 1];
    Arrays.fill(distances, Long.MAX_VALUE);

    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));

    distances[1] = 0;
    pq.offer(new Pair(1, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        long nextStartTime = next[1];

        if (nextStartTime < curr.cost) {
          nextStartTime += (long) (Math.ceil((double) (curr.cost - nextStartTime) / m) * m);
        }

        if (nextStartTime + 1 < distances[nextNodeNumber]) {
          distances[nextNodeNumber] = nextStartTime + 1;
          pq.offer(new Pair(nextNodeNumber, nextStartTime + 1));
        }
      }

    }

    return distances[n];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, i});
      graph.get(b).add(new int[]{a, i});
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