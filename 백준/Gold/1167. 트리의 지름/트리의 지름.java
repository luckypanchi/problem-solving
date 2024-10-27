import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Map<Integer, List<int[]>> graph;
  static boolean[] visited;
  static int maxCost, candidate;

  public static void main(String[] args) throws IOException {
    setUp();

    maxCost = 0;
    candidate = -1;

    visited = new boolean[n + 1];
    visited[1] = true;
    dfs(1, 0);

    visited = new boolean[n + 1];
    visited[candidate] = true;
    dfs(candidate, 0);

    sb.append(maxCost);
    output();
  }

  private static void dfs(int currNode, int prevCost) {
    if (maxCost < prevCost) {
      maxCost = prevCost;
      candidate = currNode;
    }

    for (int[] next : graph.get(currNode)) {
      int nextNode = next[0];
      int cost = next[1];
      if (!visited[nextNode]) {
        visited[nextNode] = true;
        dfs(nextNode, prevCost + cost);
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
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int nodeNumber = Integer.parseInt(st.nextToken());
      for (int next = Integer.parseInt(st.nextToken()); next != -1; next = Integer.parseInt(st.nextToken())) {
        int cost = Integer.parseInt(st.nextToken());
        graph.get(nodeNumber).add(new int[]{next, cost});
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}