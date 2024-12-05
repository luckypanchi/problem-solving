import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static boolean[] isHoliday;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, 0));

    output();
  }

  private static int solve(int curr, int couponCount) {
    if (couponCount < 0) {
      return Integer.MAX_VALUE;
    }
    if (n <= curr) {
      return 0;
    }
    if (dp[curr][couponCount] != -1) {
      return dp[curr][couponCount];
    }
    if (isHoliday[curr]) {
      dp[curr][couponCount] = solve(curr + 1, couponCount);
      return dp[curr][couponCount];
    }

    int result = Integer.MAX_VALUE;
    result = Math.min(result, solve(curr + 3, couponCount + 1) + 25000);
    result = Math.min(result, solve(curr + 5, couponCount + 2) + 37000);
    result = Math.min(result, solve(curr + 1, couponCount) + 10000);
    result = Math.min(result, solve(curr + 1, couponCount - 3));

    dp[curr][couponCount] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    dp = new int[n][2 * n + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    isHoliday = new boolean[n];
    if (m == 0) {
      return;
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st.nextToken()) - 1;
      isHoliday[target] = true;
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}