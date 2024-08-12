import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, target;
  static int[] coins;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int tcs = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < tcs; tc++) {
      n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      coins = new int[n];
      for (int i = 0; i < n; i++) {
        coins[i] = Integer.parseInt(st.nextToken());
      }
      target = Integer.parseInt(br.readLine());

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i < target + 1; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[target];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}