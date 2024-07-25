import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static char[][] board;
  static int[][] dp;
  static boolean[][] visited;
  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = moveDfs(0, 0);
    sb.append(answer);

    output();
  }

  private static int moveDfs(int y, int x) {
    if (!checkRange(y, x) || board[y][x] == 'H') {
      return 0;
    }
    if (visited[y][x]) {
      return -1;
    }
    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    int result = 0;
    int moveCount = board[y][x] - '0';
    visited[y][x] = true;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i] * moveCount;
      int nx = x + dx[i] * moveCount;

      int nextMove = moveDfs(ny, nx);
      if (nextMove == -1) {
        return -1;
      }

      result = Math.max(result, nextMove + 1);
    }

    dp[y][x] = result;
    visited[y][x] = false;
    return result;
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
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    visited = new boolean[n][m];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}