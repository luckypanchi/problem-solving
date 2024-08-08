import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static BigDecimal[] dp;

  public static void main(String[] args) throws IOException {

    dp = new BigDecimal[251];
    dp[0] = new BigDecimal(1);
    dp[1] = new BigDecimal(1);
    dp[2] = new BigDecimal(3);
    for (int i = 3; i < 251; i++) {
      dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigDecimal(2)));
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      try {
        int n = Integer.parseInt(br.readLine());
        sb.append(dp[n]).append("\n");
      } catch (Exception e) {
        break;
      }
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}