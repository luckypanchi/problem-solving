import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] dp;
  static int[] take = {1, 3, 4};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(n);
    if (answer == 1) {
      sb.append("SK");
    } else if (answer == 2) {
      sb.append("CY");
    }

    output();
  }

  private static int dfs(int left) {
    if (left < 0) {
      return -1;
    }
    if (left == 0) {
      return 2;
    }
    if (dp[left] != -1) {
      return dp[left];
    }

    dp[left] = 2;
    for (int t : take) {
      if (dfs(left - t) == 2) {
        dp[left] = 1;
      }
    }

    return dp[left];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[1001]; // 1 -> 상근 승리, 2 -> 창영 승리
    Arrays.fill(dp, -1);
    dp[1] = 2;
    dp[2] = 1;
    dp[3] = 2;
    dp[4] = 1;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}