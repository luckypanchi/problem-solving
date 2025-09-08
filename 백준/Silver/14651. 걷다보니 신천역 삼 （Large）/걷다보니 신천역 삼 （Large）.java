import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long[][][] dp;
  static final int MOD = 1_000_000_009;

  public static void main(String[] args) throws IOException {
    setUp();

    if (n == 1) {
      sb.append(0);
    } else {
      sb.append(solve());
    }

    output();
  }

  private static long solve() {
    dp[1][0][0] = 1;
    dp[1][1][1] = 1;
    dp[1][2][2] = 1;

    for (int i = 2; i < n + 1; i++) {
      for (int j = 0; j < 3; j++) {
        dp[i][j][0] = Arrays.stream(dp[i - 1][j]).sum() % MOD;
      }
      dp[i][0][1] = Arrays.stream(dp[i - 1][2]).sum() % MOD;
      dp[i][0][2] = Arrays.stream(dp[i - 1][1]).sum() % MOD;
      dp[i][1][1] = Arrays.stream(dp[i - 1][0]).sum() % MOD;
      dp[i][1][2] = Arrays.stream(dp[i - 1][2]).sum() % MOD;
      dp[i][2][1] = Arrays.stream(dp[i - 1][1]).sum() % MOD;
      dp[i][2][2] = Arrays.stream(dp[i - 1][0]).sum() % MOD;
    }

    return (dp[n][0][1] + dp[n][0][2]) % MOD;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new long[n + 1][3][3];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}