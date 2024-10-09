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
  static int[] friends;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      graph = new HashMap<>();
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());
        graph.get(a).add(new int[]{b, c});
        graph.get(b).add(new int[]{a, c});
      }
      k = Integer.parseInt(br.readLine());
      friends = new int[k];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < k; i++) {
        friends[i] = Integer.parseInt(st.nextToken());
      }

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int[][] distances = new int[n + 1][n + 1];
    for (int[] distance : distances) {
      Arrays.fill(distance, Integer.MAX_VALUE);
    }

    for (int friend : friends) {
      dijkstra(distances[friend], friend);
    }

    int minCost = Integer.MAX_VALUE;
    int answer = -1;
    for (int dest = 1; dest < n + 1; dest++) {
      int result = 0;
      for (int friend : friends) {
        result += distances[friend][dest];
      }

      if (result < minCost) {
        minCost = result;
        answer = dest;
      }
    }

    return answer;
  }

  private static void dijkstra(int[] distance, int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (distance[curr.nodeNumber] < curr.prevCost) {
        continue;
      }

      for (int[] next : graph.get(curr.nodeNumber)) {
        int nextNodeNumber = next[0];
        int cost = next[1];
        int totalCost = curr.prevCost + cost;
        if (totalCost < distance[nextNodeNumber]) {
          distance[nextNodeNumber] = totalCost;
          pq.add(new Node(nextNodeNumber, totalCost));
        }
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int nodeNumber, prevCost;

    public Node(int nodeNumber, int prevCost) {
      this.nodeNumber = nodeNumber;
      this.prevCost = prevCost;
    }

    @Override
    public int compareTo(Node o) {
      return this.prevCost - o.prevCost;
    }

  }

}