import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static char[][] board;
  static String target;
  static int[][][] dp;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == target.charAt(0)) {
          answer += dfs(i, j, 0);
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static int dfs(int y, int x, int depth) {
    if (depth == target.length() - 1) {
      return 1;
    }
    if (dp[y][x][depth] != -1) {
      return dp[y][x][depth];
    }

    int cnt = 0;
    for (int i = 0; i < 4; i++) {
      for (int length = 1; length < k + 1; length++) {
        int ny = y + length * dy[i];
        int nx = x + length * dx[i];
        if (checkRange(ny, nx) && board[ny][nx] == target.charAt(depth + 1)) {
          cnt += dfs(ny, nx, depth + 1);
        }
      }
    }

    dp[y][x][depth] = cnt;

    return dp[y][x][depth];
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    target = br.readLine();
    dp = new int[n][m][target.length()];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}