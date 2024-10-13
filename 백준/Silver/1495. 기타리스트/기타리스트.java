import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, s, m;
  static int[] volumes;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = solve(0, s);
    if (answer == Integer.MIN_VALUE) {
      answer = -1;
    }

    sb.append(answer);
    output();
  }

  private static int solve(int curr, int prev) {
    if (prev < 0 || m < prev) {
      return Integer.MIN_VALUE;
    }
    if (curr == n) {
      return prev;
    }
    if (dp[curr][prev] != -1) {
      return dp[curr][prev];
    }

    int result = Math.max(solve(curr + 1, prev + volumes[curr]), solve(curr + 1, prev - volumes[curr]));
    dp[curr][prev] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    volumes = new int[n];
    dp = new int[n][m + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      volumes[i] = Integer.parseInt(st.nextToken());
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