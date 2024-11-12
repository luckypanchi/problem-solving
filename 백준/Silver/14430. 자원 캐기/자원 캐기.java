import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
      }
    }

    sb.append(dp[n][m]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < m + 1; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
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