import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, r;
  static final long MOD = 1_000_000_007;
  static long[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp[0] = 1;
    for (int i = 1; i < n + 1; i++) {
      dp[i] = (i * dp[i - 1]) % MOD;
    }

    sb.append(dp[n] * pow(dp[n - r] * dp[r] % MOD, MOD - 2) % MOD);
    output();
  }

  private static long pow(long target, long count) {
    if (count == 0) {
      return 1;
    }
    if (count == 1) {
      return target;
    }

    long half = pow(target % MOD, count / 2) % MOD;
    long result = half * half % MOD;

    if (count % 2 == 0) {
      return result;
    } else {
      return result * target % MOD;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    dp = new long[n + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}