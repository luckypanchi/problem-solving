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
  static int n, start, end, answer;
  static Map<Integer, List<int[]>> graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    visited[start] = true;
    dfs(start, 0, 0);

    sb.append(answer);
    output();
  }

  private static void dfs(int curr, int totalSum, int maxCost) {
    if (curr == end) {
      answer = Math.min(answer, totalSum - maxCost);
      return;
    }

    for (int[] next : graph.get(curr)) {
      int nextNode = next[0];
      int cost = next[1];
      if (!visited[nextNode]) {
        visited[nextNode] = true;
        dfs(nextNode, totalSum + cost, Math.max(maxCost, cost));
        visited[nextNode] = false;
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
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

}