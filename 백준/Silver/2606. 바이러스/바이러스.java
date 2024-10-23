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
  static int n, m, answer;
  static Map<Integer, List<Integer>> graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = 0;
    dfs(1);
    answer--;

    sb.append(answer);
    output();
  }

  private static void dfs(int curr) {
    visited[curr] = true;
    answer++;

    for (int next : graph.get(curr)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    visited = new boolean[n + 1];
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}