import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    int[] depth = new int[n + 1];
    Arrays.fill(depth, -1);
    depth[r] = 0;

    int[] visited = new int[n + 1];
    visited[r] = 1;

    int count = 1;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(r);

    while (!que.isEmpty()) {
      int cur = que.poll();

      for (int next : graph.get(cur)) {
        if (visited[next] == 0) {
          visited[next] = ++count;
          depth[next] = depth[cur] + 1;
          que.offer(next);
        }
      }
    }

    long answer = 0L;
    for (int i = 1; i < n + 1; i++) {
      answer += (long) depth[i] * visited[i];
    }
    sb.append(answer);

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
    for (int i = 1; i < n + 1; i++) {
      Collections.sort(graph.get(i));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}