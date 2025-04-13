import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, r;
  static Map<Integer, List<Integer>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] visited = new int[n + 1];
    Arrays.fill(visited, -1);
    visited[r] = 0;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(r);

    while (!que.isEmpty()) {
      int cur = que.poll();

      for (int next : graph.get(cur)) {
        if (visited[next] == -1) {
          visited[next] = visited[cur] + 1;
          que.offer(next);
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      sb.append(visited[i]).append("\n");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    graph = new HashMap<>();
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