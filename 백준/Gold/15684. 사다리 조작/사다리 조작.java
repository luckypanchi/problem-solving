import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, h;
  static boolean[][] ladderRows;
  static int answer;

  public static void main(String[] args) throws IOException {
    setUp();

    dfs(0, 0);

    if (answer == Integer.MAX_VALUE) {
      answer = -1;
    }

    sb.append(answer);
    output();
  }

  private static void dfs(int curr, int prevCount) {
    if (3 < prevCount) {
      return;
    }
    if (curr == n * h) {
      if (check()) {
        answer = Math.min(answer, prevCount);
      }
      return;
    }

    int y = curr / n;
    int x = curr % n;

    dfs(curr + 1, prevCount);

    if (!ladderRows[y][x] && checkRow(y, x)) {
      ladderRows[y][x] = true;
      dfs(curr + 1, prevCount + 1);
      ladderRows[y][x] = false;
    }
  }

  private static boolean check() {
    for (int x = 0; x < n; x++) {
      int curr = x;
      for (int y = 0; y < h; y++) {
        if (curr != n - 1 && ladderRows[y][curr]) {
          curr++;
        } else if (curr != 0 && ladderRows[y][curr - 1]) {
          curr--;
        }
      }
      if (curr != x) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkRow(int y, int x) {
    if (x == n - 1) {
      return false;
    }

    if (n == 2) {
      return true;
    }

    if (x == 0) {
      return !ladderRows[y][x + 1];
    }

    if (x == n - 2) {
      return !ladderRows[y][x - 1];
    }

    return !ladderRows[y][x + 1] && !ladderRows[y][x - 1];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    ladderRows = new boolean[h][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      ladderRows[a][b] = true;
    }
    answer = Integer.MAX_VALUE;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}