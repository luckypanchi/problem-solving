import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int t, k;
  static int[][] coins, dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp[0][0] = 1;
    for (int i = 1; i < k + 1; i++) {
      int coin = coins[i][0];
      int count = coins[i][1];

      for (int c = 0; c < count + 1; c++) {
        for (int prev = 0; prev < t + 1; prev++) {
          int total = prev + coin * c;
          if (total <= t) {
            dp[i][total] += dp[i - 1][prev];
          }
        }
      }
    }

    sb.append(dp[k][t]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    t = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
    coins = new int[k + 1][2];
    dp = new int[k + 1][t + 1];
    for (int i = 1; i < k + 1; i++) {
      st = new StringTokenizer(br.readLine());
      coins[i][0] = Integer.parseInt(st.nextToken());
      coins[i][1] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}