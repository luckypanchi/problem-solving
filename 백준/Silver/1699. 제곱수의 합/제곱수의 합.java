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

    dp = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      dp[i] = i;
      for (int j = 1; j * j < i + 1; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    sb.append(dp[n]);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}