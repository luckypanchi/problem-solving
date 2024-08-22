import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, a, b;
  static int[][] constraints;

  public static void main(String[] args) throws IOException {
    setUp();

    Deque<int[]> que = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];
    int answer = -1;

    que.offer(new int[]{0, 0});
    visited[0] = true;

    while (!que.isEmpty()) {
      int[] curr = que.poll();
      if (curr[0] == n) {
        answer = curr[1];
        break;
      }

      for (int next : new int[]{curr[0] + a, curr[0] + b}) {
        if (next < n + 1 && !visited[next]) {
          visited[next] = true;
          if (check(next)) {
            que.offer(new int[]{next, curr[1] + 1});
          }
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static boolean check(int number) {
    for (int[] con : constraints) {
      if (con[0] <= number && number <= con[1]) {
        return false;
      }
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    constraints = new int[m][2];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      constraints[i][0] = Integer.parseInt(st.nextToken());
      constraints[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(constraints, Comparator.comparing(o -> o[0]));
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}