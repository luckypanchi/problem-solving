import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, c;
  static int[][] infos;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(0, 0);
    sb.append(answer);

    output();
  }

  private static int dfs(int curr, int w) {
    if (c <= w) {
      return 0;
    }
    if (n <= curr) {
      return Integer.MAX_VALUE;
    }
    if (dp[curr][w] != -1) {
      return dp[curr][w];
    }

    int cost = infos[curr][0];
    int client = infos[curr][1];

    int result = Integer.MAX_VALUE;
    result = Math.min(result, dfs(curr, w + client) + cost);
    result = Math.min(result, dfs(curr + 1, w));

    dp[curr][w] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    infos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      infos[i][0] = Integer.parseInt(st.nextToken());
      infos[i][1] = Integer.parseInt(st.nextToken());
    }
    dp = new int[n][1001];
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