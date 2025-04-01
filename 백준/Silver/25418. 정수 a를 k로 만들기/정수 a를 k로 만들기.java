import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, k;
  static int[] visited;

  public static void main(String[] args) throws IOException {
    setUp();

    visited = new int[k + 1];
    Deque<Integer> que = new ArrayDeque<>();
    que.offer(a);
    visited[a] = 1;
    while (!que.isEmpty()) {
      int curr = que.poll();

      if (curr + 1 <= k && visited[curr + 1] == 0) {
        visited[curr + 1] = visited[curr] + 1;
        que.offer(curr + 1);
      }

      if (2 * curr <= k && visited[2 * curr] == 0) {
        visited[2 * curr] = visited[curr] + 1;
        que.offer(2 * curr);
      }
    }

    sb.append(visited[k] - 1);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}