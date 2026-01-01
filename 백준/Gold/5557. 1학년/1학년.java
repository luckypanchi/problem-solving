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
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new long[n][21];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    sb.append(dfs(1, numbers[0]));
    output();
  }

  private static long dfs(int curr, int left) {
    if (curr == n - 1) {
      return left == numbers[n - 1] ? 1 : 0;
    }
    if (left < 0 || 20 < left) {
      return 0;
    }
    if (dp[curr][left] != -1) {
      return dp[curr][left];
    }

    dp[curr][left] = dfs(curr + 1, left + numbers[curr]) + dfs(curr + 1, left - numbers[curr]);
    return dp[curr][left];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}