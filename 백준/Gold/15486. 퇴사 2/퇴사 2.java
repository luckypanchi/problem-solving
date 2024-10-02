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
  static int[][] consults;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dfs(0));

    output();
  }

  private static int dfs(int curr) {
    if (n < curr) {
      return Integer.MIN_VALUE;
    }
    if (curr == n) {
      return 0;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    int timeCost = consults[curr][0];
    int cost = consults[curr][1];
    int result = Integer.max(dfs(curr + 1), dfs(curr + timeCost) + cost);
    dp[curr] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    consults = new int[n][2];
    dp = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      consults[i][0] = Integer.parseInt(st.nextToken());
      consults[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.fill(dp, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}