import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static Map<Integer, List<Integer>> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      map.put(i, new ArrayList<>());
    }

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      st.nextToken();
      String b = st.nextToken();
      map.get(a.charAt(0) - 'a').add(b.charAt(0) - 'a');
    }
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      String start = st.nextToken();
      st.nextToken();
      String end = st.nextToken();

      sb.append(solve(start, end)).append("\n");
    }

    output();
  }

  private static String solve(String start, String end) {
    boolean[] visited = new boolean[26];
    visited[start.charAt(0) - 'a'] = true;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(start.charAt(0) - 'a');
    while (!que.isEmpty()) {
      int curr = que.poll();

      for (int next : map.get(curr)) {
        if (!visited[next]) {
          visited[next] = true;
          que.offer(next);
        }
      }
    }

    return visited[end.charAt(0) - 'a'] ? "T" : "F";
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}