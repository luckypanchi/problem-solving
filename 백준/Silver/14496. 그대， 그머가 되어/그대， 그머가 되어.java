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
  static int a, b;
  static int n, m;
  static Map<Integer, List<Integer>> map;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] visited = new int[n + 1];
    Arrays.fill(visited, -1);
    visited[a] = 0;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(a);

    while (!que.isEmpty()) {
      int curr = que.poll();

      if (curr == b) {
        break;
      }

      for (int next : map.get(curr)) {
        if (visited[next] == -1) {
          visited[next] = visited[curr] + 1;
          que.offer(next);
        }
      }
    }

    sb.append(visited[b]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      map.put(i, new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map.get(a).add(b);
      map.get(b).add(a);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}