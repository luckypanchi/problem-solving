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
  static int[] cards;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int tcs = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < tcs; tc++) {
      n = Integer.parseInt(br.readLine());
      cards = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        cards[i] = Integer.parseInt(st.nextToken());
      }

      dp = new int[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], -1);
      }
      sb.append(dfs(0, n - 1)).append("\n");
    }

    output();
  }

  private static int dfs(int start, int end) {
    if (end < start) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    int sum = 0;
    for (int i = start; i < end + 1; i++) {
      sum += cards[i];
    }

    dp[start][end] = Math.max(sum - dfs(start, end - 1), sum - dfs(start + 1, end));

    return dp[start][end];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}