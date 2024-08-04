import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = dfs(n);
    sb.append(answer);

    output();
  }

  private static long dfs(int curr) {
    if (curr <= 0) {
      return 0;
    }
    if (curr == 1) {
      return 1;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    dp[curr] = dfs(curr - 1) + 1;
    for (int i = 2; i < curr; i++) {
      dp[curr] = Math.max(dp[curr], dfs(curr - (i + 1)) * i);
    }

    return dp[curr];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new long[n + 1];
    Arrays.fill(dp, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}