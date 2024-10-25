import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] weights;
  static int[] values;

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] dp = new int[n + 1][k + 1];

    for (int currStuff = 1; currStuff < n + 1; currStuff++) {
      for (int currWeight = 1; currWeight < k + 1; currWeight++) {
        if (weights[currStuff] <= currWeight) {
          dp[currStuff][currWeight] = Math.max(dp[currStuff - 1][currWeight],
              values[currStuff] + dp[currStuff - 1][currWeight - weights[currStuff]]);
        } else {
          dp[currStuff][currWeight] = dp[currStuff - 1][currWeight];
        }
      }
    }

    sb.append(dp[n][k]);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    weights = new int[n + 1];
    values = new int[n + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i + 1] = Integer.parseInt(st.nextToken());
      values[i + 1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}