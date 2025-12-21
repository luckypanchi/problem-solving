import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] wines;
  static int[][][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    if (n < 2) {
      sb.append(sum(wines));
    } else {
      int answer = max(
          dfs(2, 0, 0),
          wines[0] + dfs(2, 0, 1),
          wines[1] + dfs(2, 1, 0),
          wines[0] + wines[1] + dfs(2, 1, 1));
      sb.append(answer);
    }

    output();
  }

  private static int dfs(int curr, int prev, int pprev) {
    if (curr == n) {
      return 0;
    }
    if (dp[curr][prev][pprev] != -1) {
      return dp[curr][prev][pprev];
    }

    int result = 0;
    if (prev == 1 && pprev == 1) {
      result = dfs(curr + 1, 0, prev);
    } else {
      result = Math.max(dfs(curr + 1, 0, prev), wines[curr] + dfs(curr + 1, 1, prev));
    }

    dp[curr][prev][pprev] = result;
    return result;
  }

  private static int sum(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }

  private static int max(int a, int b, int c, int d) {
    return Math.max(Math.max(a, b), Math.max(c, d));
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    wines = new int[n];
    for (int i = 0; i < n; i++) {
      wines[i] = Integer.parseInt(br.readLine());
    }
    dp = new int[n][2][2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) {
          dp[i][j][k] = -1;
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