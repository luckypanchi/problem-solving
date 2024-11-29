import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String ordered;
  static String[] bridges;

  public static void main(String[] args) throws IOException {
    setUp();

    int n = ordered.length();
    int m = bridges[0].length();

    int[][][] dp = new int[n + 1][2][m + 1];

    Arrays.fill(dp[0][0], 1);
    Arrays.fill(dp[0][1], 1);
    
    for (int orderedIndex = 1; orderedIndex < n + 1; orderedIndex++) {
      for (int bridgeType = 0; bridgeType < 2; bridgeType++) {
        for (int bridgeIndex = 1; bridgeIndex < m + 1; bridgeIndex++) {
          dp[orderedIndex][bridgeType][bridgeIndex] = dp[orderedIndex][bridgeType][bridgeIndex - 1];
          if (ordered.charAt(orderedIndex - 1) == bridges[bridgeType].charAt(bridgeIndex - 1)) {
            dp[orderedIndex][bridgeType][bridgeIndex] += dp[orderedIndex - 1][1 - bridgeType][bridgeIndex - 1];
          }
        }
      }
    }

    sb.append(dp[n][0][m] + dp[n][1][m]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ordered = br.readLine();
    bridges = new String[2];
    bridges[0] = br.readLine();
    bridges[1] = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}