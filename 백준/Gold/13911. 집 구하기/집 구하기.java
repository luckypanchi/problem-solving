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
  static int n, m, x, y, macCount, starCount;
  static Map<Integer, List<int[]>> graph;
  static int[] macNodes, starNodes;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] startFromMac = dijkstra(macNodes);
    int[] startFromStar = dijkstra(starNodes);

    int answer = Integer.MAX_VALUE;
    for (int i = 1; i < n + 1; i++) {
      if (0 < startFromMac[i] && startFromMac[i] <= x && 0 < startFromStar[i] && startFromStar[i] <= y) {
        answer = Math.min(answer, startFromMac[i] + startFromStar[i]);
      }
    }

    answer = answer == Integer.MAX_VALUE ? -1 : answer;

    sb.append(answer);
    output();
  }

  private static int[] dijkstra(int[] startNodes) {
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    for (int startNode : startNodes) {
      distances[startNode] = 0;
      pq.offer(new Pair(startNode, 0));
    }

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int totalCost = curr.cost + next[1];
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
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }
    st = new StringTokenizer(br.readLine());
    macCount = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    macNodes = new int[macCount];
    for (int i = 0; i < macCount; i++) {
      macNodes[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    starCount = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    starNodes = new int[starCount];
    for (int i = 0; i < starCount; i++) {
      starNodes[i] = Integer.parseInt(st.nextToken());
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