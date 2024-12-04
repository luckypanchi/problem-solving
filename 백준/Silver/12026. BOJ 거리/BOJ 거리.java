import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String street;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      if (dp[i] == Integer.MAX_VALUE) {
        continue;
      }

      for (int j = i + 1; j < n; j++) {
        int cost = (j - i) * (j - i);
        if ((street.charAt(i) == 'B' && street.charAt(j) == 'O')
            || (street.charAt(i) == 'O' && street.charAt(j) == 'J')
            || (street.charAt(i) == 'J' && street.charAt(j) == 'B')) {
          dp[j] = Math.min(dp[j], dp[i] + cost);
        }
      }
    }

    sb.append(dp[n - 1] != Integer.MAX_VALUE ? dp[n - 1] : -1);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    street = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}