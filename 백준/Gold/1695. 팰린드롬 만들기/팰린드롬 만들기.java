import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = solve(0, n - 1);

    sb.append(answer);
    output();
  }

  private static int solve(int left, int right) {
    if (right <= left) {
      return 0;
    }
    if (dp[left][right] != -1) {
      return dp[left][right];
    }

    int result = Integer.MAX_VALUE;
    if (numbers[left] == numbers[right]) {
      result = solve(left + 1, right - 1);
    } else {
      result = Math.min(result, solve(left + 1, right) + 1);
      result = Math.min(result, solve(left, right - 1) + 1);
    }

    dp[left][right] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    dp = new int[n][n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}