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

    int[] foxDistances = dijkstraFox();
    int[] wolfDistances = dijkstraWolf();

    int answer = 0;
    for (int i = 2; i < n + 1; i++) {
      if (foxDistances[i] < wolfDistances[i]) {
        answer++;
      }
    }

    sb.append(answer);
    output();
  }

  private static int[] dijkstraFox() {
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.add(new Pair(1, 0));
    distances[1] = 0;

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int cost = next[1];
        int nextTotalCost = curr.cost + cost;

        if (nextTotalCost < distances[nextNodeNumber]) {
          distances[nextNodeNumber] = nextTotalCost;
          pq.offer(new Pair(nextNodeNumber, nextTotalCost));
        }
      }
    }

    return distances;
  }

  private static int[] dijkstraWolf() {
    int[][] distances = new int[2][n + 1];
    Arrays.fill(distances[0], Integer.MAX_VALUE);
    Arrays.fill(distances[1], Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    pq.add(new Pair(1, 0, 1));
    distances[1][1] = 0;

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.moveFast][curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int cost = next[1];
        int nextTotalCost = curr.cost;

        if (curr.moveFast == 1) {
          nextTotalCost += cost / 2;
        } else {
          nextTotalCost += cost * 2;
        }

        if (nextTotalCost < distances[1 - curr.moveFast][nextNodeNumber]) {
          distances[1 - curr.moveFast][nextNodeNumber] = nextTotalCost;
          pq.offer(new Pair(nextNodeNumber, nextTotalCost, 1 - curr.moveFast));
        }
      }
    }

    int[] newDistances = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      newDistances[i] = Math.min(distances[0][i], distances[1][i]);
    }

    return newDistances;
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
      int d = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, 2 * d});
      graph.get(b).add(new int[]{a, 2 * d});
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair implements Comparable<Pair> {

    int nodeNumber, cost;
    int moveFast;

    public Pair(int nodeNumber, int cost) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
    }

    public Pair(int nodeNumber, int cost, int moveFast) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
      this.moveFast = moveFast;
    }

    @Override
    public int compareTo(Pair o) {
      return this.cost - o.cost;
    }
  }

}