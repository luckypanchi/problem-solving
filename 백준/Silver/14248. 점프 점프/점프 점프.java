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
  static int n, start;
  static int[] dists;

  public static void main(String[] args) throws IOException {
    setUp();

    boolean[] visited = new boolean[n + 1];
    visited[start] = true;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(start);

    while (!que.isEmpty()) {
      int curr = que.poll();
      int jump = dists[curr];

      if (curr + jump < n + 1 && !visited[curr + jump]) {
        visited[curr + jump] = true;
        que.offer(curr + jump);
      }

      if (0 < curr - jump && !visited[curr - jump]) {
        visited[curr - jump] = true;
        que.offer(curr - jump);
      }
    }

    int answer = 0;
    for (int i = 1; i < n + 1; i++) {
      if (visited[i]) {
        answer++;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    dists = new int[n + 1];
    for (int i = 0; i < n; i++) {
      dists[i + 1] = Integer.parseInt(st.nextToken());
    }
    start = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}