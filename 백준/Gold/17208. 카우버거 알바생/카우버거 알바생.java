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
  static int[][] orders;
  static int[][][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, 0, 0));

    output();
  }

  private static int solve(int curr, int prevBurger, int prevFries) {
    if (m < prevBurger || k < prevFries) {
      return Integer.MIN_VALUE;
    }
    if (curr == n) {
      return 0;
    }
    if (dp[curr][prevBurger][prevFries] != -1) {
      return dp[curr][prevBurger][prevFries];
    }

    int[] currOrder = orders[curr];
    dp[curr][prevBurger][prevFries] = Math.max(1 + solve(curr + 1, prevBurger + currOrder[0], prevFries + currOrder[1]), solve(curr + 1, prevBurger, prevFries));

    return dp[curr][prevBurger][prevFries];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    orders = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      orders[i][0] = Integer.parseInt(st.nextToken());
      orders[i][1] = Integer.parseInt(st.nextToken());
    }
    dp = new int[n][m + 1][k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m + 1; j++) {
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