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
  static int[] starts;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] distances = new int[3][n + 1];
    for (int i = 0; i < 3; i++) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
      dijkstra(starts[i], distances[i]);
    }

    int maxDist = -1;
    int answer = -1;
    for (int i = 1; i < n + 1; i++) {
      int dist = min(distances[0][i], distances[1][i], distances[2][i]);
      if (maxDist < dist) {
        maxDist = dist;
        answer = i;
      }
    }

    sb.append(answer);

    output();
  }

  private static int min(int num1, int num2, int num3) {
    return Math.min(num1, Math.min(num2, num3));
  }

  private static void dijkstra(int start, int[] distance) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    distance[start] = 0;
    pq.offer(new Pair(start, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distance[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int totalCost = curr.cost + next[1];
        if (totalCost < distance[nextNodeNumber]) {
          distance[nextNodeNumber] = totalCost;
          pq.offer(new Pair(nextNodeNumber, totalCost));
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    starts = new int[3];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      starts[i] = Integer.parseInt(st.nextToken());
    }
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
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

  private static class Pair {

    int nodeNumber, cost;

    public Pair(int nodeNumber, int cost) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
    }
  }

}