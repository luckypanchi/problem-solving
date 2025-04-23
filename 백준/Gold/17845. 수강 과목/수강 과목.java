import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] costs, weights;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < k + 1; i++) {
      int cost = costs[i];
      int weight = weights[i];

      for (int currTime = 0; currTime < n + 1; currTime++) {
        dp[i][currTime] = dp[i - 1][currTime];
        if (0 <= currTime - weight) {
          dp[i][currTime] = Math.max(dp[i - 1][currTime], dp[i - 1][currTime - weight] + cost);
        }
      }
    }

    sb.append(dp[k][n]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    costs = new int[k + 1];
    weights = new int[k + 1];
    for (int i = 1; i < k + 1; i++) {
      st = new StringTokenizer(br.readLine());
      costs[i] = Integer.parseInt(st.nextToken());
      weights[i] = Integer.parseInt(st.nextToken());
    }
    dp = new int[k + 1][n + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}