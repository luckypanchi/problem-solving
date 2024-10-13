import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, d;
  static int[][] graph;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0));
    output();
  }

  private static int solve(int curr) {
    if (curr == d) {
      return 0;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    int result = d - curr;
    for (int i = 0; i < n; i++) {
      int start = graph[i][0];
      int end = graph[i][1];
      int dist = graph[i][2];
      if (curr <= start && end <= d) {
        result = Math.min(result, solve(end) + start - curr + dist);
      }
    }

    dp[curr] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    graph = new int[n][3];
    dp = new int[d + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      graph[i][0] = Integer.parseInt(st.nextToken());
      graph[i][1] = Integer.parseInt(st.nextToken());
      graph[i][2] = Integer.parseInt(st.nextToken());
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