import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[][] stuffs;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, 0));

    output();
  }

  private static int solve(int curr, int prevWeights) {
    if (k < prevWeights) {
      return Integer.MIN_VALUE;
    }
    if (curr == n || prevWeights == k) {
      return 0;
    }
    if (dp[curr][prevWeights] != -1) {
      return dp[curr][prevWeights];
    }

    int result = Integer.MIN_VALUE;
    result = Math.max(result, solve(curr + 1, prevWeights));
    result = Math.max(result, solve(curr + 1, prevWeights + stuffs[curr][0]) + stuffs[curr][1]);

    dp[curr][prevWeights] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    stuffs = new int[n][2];
    dp = new int[n][k + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      stuffs[i][0] = Integer.parseInt(st.nextToken());
      stuffs[i][1] = Integer.parseInt(st.nextToken());
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