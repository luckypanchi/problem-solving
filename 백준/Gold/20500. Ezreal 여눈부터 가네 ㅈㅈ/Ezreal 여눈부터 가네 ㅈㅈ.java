import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static final long MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    setUp();

    long[][] dp = new long[3][1515 + 1];
    dp[0][2] = 1;
    dp[1][2] = 1;

    for (int i = 3; i < 1515 + 1; i++) {
      dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % MOD;
      dp[1][i] = (dp[2][i - 1] + dp[0][i - 1]) % MOD;
      dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
    }

    sb.append(dp[0][n]);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
