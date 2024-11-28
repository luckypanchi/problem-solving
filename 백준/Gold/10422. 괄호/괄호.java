import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static final int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long[] dp = new long[5001];
    dp[0] = 1L;
    dp[2] = 1L;

    for (int i = 4; i < 5001; i += 2) {
      for (int j = 0; j < i; j += 2) {
        dp[i] += dp[j] * dp[i - j - 2];
        dp[i] %= MOD;
      }
    }

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      int target = Integer.parseInt(br.readLine());
      sb.append(dp[target]).append("\n");
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}