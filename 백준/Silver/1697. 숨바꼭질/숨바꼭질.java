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
  static int n, k;
  static final int MAX_LENGTH = 100_000;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    int[] visited = new int[MAX_LENGTH + 1];
    Deque<Integer> que = new ArrayDeque<>();

    visited[n] = 1;
    que.offer(n);

    while (!que.isEmpty()) {
      int curr = que.poll();

      if (curr == k) {
        break;
      }

      for (int next : new int[]{curr - 1, curr + 1, 2 * curr}) {
        if (0 <= next && next < MAX_LENGTH + 1 && visited[next] == 0) {
          visited[next] = visited[curr] + 1;
          que.offer(next);

        }
      }
    }

    return visited[k] - 1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}