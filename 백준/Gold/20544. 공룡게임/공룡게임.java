import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static final int MOD = 1_000_000_007;
  static int[][][][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = solve(0, 0, 0, 0);

    sb.append(answer);
    output();
  }

  /**
   * @param curr       : 현재 위치
   * @param prevHeight : 이전 높이
   * @param currHeight : 현재 높이
   * @param isIncluded : 높이 2를 포함하는지(최소 1개는 포함해야 한다.)
   */
  private static int solve(int curr, int prevHeight, int currHeight, int isIncluded) {
    if (curr == n - 1) {
      return isIncluded;
    }
    if (dp[curr][prevHeight][currHeight][isIncluded] != -1) {
      return dp[curr][prevHeight][currHeight][isIncluded];
    }

    int result = solve(curr + 1, currHeight, 0, isIncluded) % MOD;
    if (currHeight == 0) {
      result = (result + solve(curr + 1, currHeight, 1, isIncluded)) % MOD;
      result = (result + solve(curr + 1, currHeight, 2, 1)) % MOD;
    } else if (currHeight == 1 && prevHeight == 0) {
      result = (result + solve(curr + 1, currHeight, 1, isIncluded)) % MOD;
      result = (result + solve(curr + 1, currHeight, 2, 1)) % MOD;
    } else if (currHeight == 2 && prevHeight == 0) {
      result = (result + solve(curr + 1, currHeight, 1, isIncluded)) % MOD;
    }

    dp[curr][prevHeight][currHeight][isIncluded] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[n][3][3][2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
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