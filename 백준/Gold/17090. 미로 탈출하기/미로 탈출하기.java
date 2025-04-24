import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static char[][] board;
  static int[][] dp;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        answer += dfs(i, j);
      }
    }

    sb.append(answer);

    output();
  }

  private static int dfs(int y, int x) {
    if (!checkRange(y, x)) {
      return 1;
    }
    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    int ny = y;
    int nx = x;
    if (board[y][x] == 'U') {
      ny--;
    } else if (board[y][x] == 'R') {
      nx++;
    } else if (board[y][x] == 'D') {
      ny++;
    } else if (board[y][x] == 'L') {
      nx--;
    }

    dp[y][x] = 0;
    dp[y][x] = dfs(ny, nx);

    return dp[y][x];
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j);
        dp[i][j] = -1;
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