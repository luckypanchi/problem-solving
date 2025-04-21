import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long[][] dp;
  static final int MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    setUp();

    dp[1][0] = 2;
    dp[2][0] = 7;
    dp[2][1] = 1;

    for (int i = 3; i < n + 1; i++) {
      dp[i][1] = (dp[i - 3][0] + dp[i - 1][1]) % MOD;
      dp[i][0] = (2 * dp[i][1] + 2 * dp[i - 1][0] + 3 * dp[i - 2][0]) % MOD;
    }

    sb.append(dp[n][0]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new long[1000001][2];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}