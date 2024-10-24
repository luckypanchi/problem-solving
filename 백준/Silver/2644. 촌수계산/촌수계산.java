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
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, start, dest;
  static Map<Integer, List<Integer>> graph;
  static int[] depth;

  public static void main(String[] args) throws IOException {
    setUp();

    depth[start] = 0;
    dfs(start, 0);

    sb.append(depth[dest]);

    output();
  }

  private static void dfs(int curr, int currDepth) {
    if (curr == dest) {
      return;
    }

    for (int next : graph.get(curr)) {
      if (depth[next] == -1) {
        depth[next] = currDepth + 1;
        dfs(next, currDepth + 1);
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
    depth = new int[n + 1];
    Arrays.fill(depth, -1);
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    dest = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());
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