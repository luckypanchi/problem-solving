import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int s, a, b, c;
  static long[][][][] dp;
  static final int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, a, b, c));

    output();
  }

  private static long solve(int curr, int remainA, int remainB, int remainC) {
    if (curr == s) {
      return remainA == 0 && remainB == 0 && remainC == 0 ? 1 : 0;
    }
    if (dp[curr][remainA][remainB][remainC] != -1) {
      return dp[curr][remainA][remainB][remainC];
    }

    long result = 0;
    if (0 < remainA) {
      result += solve(curr + 1, remainA - 1, remainB, remainC);
      result = result % MOD;
    }
    if (0 < remainB) {
      result += solve(curr + 1, remainA, remainB - 1, remainC);
      result = result % MOD;
    }
    if (0 < remainC) {
      result += solve(curr + 1, remainA, remainB, remainC - 1);
      result = result % MOD;
    }
    if (0 < remainA && 0 < remainB) {
      result += solve(curr + 1, remainA - 1, remainB - 1, remainC);
      result = result % MOD;
    }
    if (0 < remainB && 0 < remainC) {
      result += solve(curr + 1, remainA, remainB - 1, remainC - 1);
      result = result % MOD;
    }
    if (0 < remainC && 0 < remainA) {
      result += solve(curr + 1, remainA - 1, remainB, remainC - 1);
      result = result % MOD;
    }
    if (0 < remainA && 0 < remainB && 0 < remainC) {
      result += solve(curr + 1, remainA - 1, remainB - 1, remainC - 1);
      result = result % MOD;
    }

    dp[curr][remainA][remainB][remainC] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    dp = new long[s][a + 1][b + 1][c + 1];
    for (int i = 0; i < s; i++) {
      for (int j = 0; j < a + 1; j++) {
        for (int k = 0; k < b + 1; k++) {
          Arrays.fill(dp[i][j][k], -1);
        }
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