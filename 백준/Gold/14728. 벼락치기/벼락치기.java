import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, t;
  static int[][] chapters;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = Math.max(dfs(1, t), dfs(1, t - chapters[0][0]) + chapters[0][1]);
    sb.append(answer);

    output();
  }

  private static int dfs(int curr, int leftTime) {
    if (leftTime < 0) {
      return Integer.MIN_VALUE;
    }
    if (curr == n) {
      return 0;
    }
    if (dp[curr][leftTime] != -1) {
      return dp[curr][leftTime];
    }

    int result = Math.max(dfs(curr + 1, leftTime), dfs(curr + 1, leftTime - chapters[curr][0]) + chapters[curr][1]);
    dp[curr][leftTime] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    chapters = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      chapters[i][0] = Integer.parseInt(st.nextToken());
      chapters[i][1] = Integer.parseInt(st.nextToken());
    }

    dp = new int[n][t + 1];
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