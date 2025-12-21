import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp[2] = 3;
    if (n % 2 != 0) {
      sb.append(0);
    } else {
      for (int i = 4; i < 31; i++) {
        if (n % 2 == 0) {
          dp[i] += dp[i - 2] * 3;
          for (int j = 2; j <= i - 4; j += 2) {
            dp[i] += dp[j] * 2;
          }
          dp[i] += 2;
        }
      }
      sb.append(dp[n]);
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[31];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}