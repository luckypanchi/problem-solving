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
  static int[] prevNode;

  public static void main(String[] args) throws IOException {
    setUp();

    int originalEscapeTime = dijkstra(-1, -1);

    List<int[]> pathList = new ArrayList<>();
    for (int i = n; i > 1; i = prevNode[i]) {
      pathList.add(new int[]{prevNode[i], i});
    }

    int answer = 0;
    for (int[] target : pathList) {
      int escapeTime = dijkstra(target[0], target[1]);
      if (escapeTime == Integer.MAX_VALUE) {
        answer = -1;
        break;
      }
      answer = Math.max(answer, escapeTime - originalEscapeTime);
    }

    sb.append(answer);
    output();
  }

  private static int dijkstra(int start, int end) {
    int[] distances = new int[n + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    distances[1] = 0;
    pq.offer(new Pair(1, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int nextCost = next[1];
        int totalCost = curr.cost + nextCost;
        if (totalCost < distances[nextNodeNumber] && !(start == curr.nodeNumber && end == nextNodeNumber)) {
          distances[nextNodeNumber] = totalCost;
          prevNode[nextNodeNumber] = curr.nodeNumber;
          pq.offer(new Pair(nextNodeNumber, totalCost));
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
    prevNode = new int[n + 1];
    for (int i = 0; i < n; i++) {
      graph.put(i + 1, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, t});
      graph.get(b).add(new int[]{a, t});
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

    public Pair(int nodeNumber, int cost) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
      return this.cost - o.cost;
    }
  }

}