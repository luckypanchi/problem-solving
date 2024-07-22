import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String string1, string2, string3;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = getLcsLength();
    sb.append(answer);

    output();
  }

  private static int getLcsLength() {
    int[][][] dp = new int[string1.length() + 1][string2.length() + 1][string3.length() + 1];

    for (int i = 0; i < string1.length() + 1; i++) {
      for (int j = 0; j < string2.length() + 1; j++) {
        for (int k = 0; k < string3.length() + 1; k++) {
          if (i == 0 || j == 0 || k == 0) {
            dp[i][j][k] = 0;
          } else if (string1.charAt(i - 1) == string2.charAt(j - 1) && string2.charAt(j - 1) == string3.charAt(k - 1)) {
            dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
          } else {
            dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
          }
        }
      }
    }

    return dp[string1.length()][string2.length()][string3.length()];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    string1 = br.readLine();
    string2 = br.readLine();
    string3 = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}