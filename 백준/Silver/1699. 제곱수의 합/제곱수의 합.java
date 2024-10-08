import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(n));

    output();
  }

  private static int solve(int target) {
    if (Math.sqrt(target) % 1 == 0) {
      return 1;
    }
    if (dp[target] != -1) {
      return dp[target];
    }

    int result = Integer.MAX_VALUE;
    for (int i = 1; i * i <= target; i++) {
      result = Math.min(result, solve(target - i * i) + 1);
    }

    dp[target] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];
    Arrays.fill(dp, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}