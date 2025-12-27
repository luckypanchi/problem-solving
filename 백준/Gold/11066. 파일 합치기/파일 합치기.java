import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int k;
  static int[] prefixSum;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());

    while (testcases-- > 0) {
      k = Integer.parseInt(br.readLine());
      prefixSum = new int[k + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i < k + 1; i++) {
        int chapter = Integer.parseInt(st.nextToken());
        prefixSum[i] += prefixSum[i - 1] + chapter;
      }
      dp = new int[k + 1][k + 1];
      for (int length = 1; length < k + 1; length++) {
        for (int start = 1; start + length < k + 1; start++) {
          int end = start + length;
          dp[start][end] = getMinCost(start, end, length) + prefixSum[end] - prefixSum[start - 1];
        }
      }

      sb.append(dp[1][k]).append("\n");
    }

    output();
  }

  private static int getMinCost(int start, int end, int length) {
    int result = Integer.MAX_VALUE;
    for (int len = 0; len < length; len++) {
      result = Math.min(result, dp[start][start + len] + dp[start + len + 1][end]);
    }
    return result;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}