import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String target;

  public static void main(String[] args) throws IOException {
    setUp();

    int n = target.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 1; i < n; i++) {
      if (parseNumber(i) != 0) {
        dp[i + 1] += dp[i];
      }

      if (checkCombine(i - 1, i)) {
        dp[i + 1] += dp[i - 1];
      }
    }

    sb.append(dp[n]);
    output();
  }

  private static boolean checkCombine(int prev, int curr) {
    int prevNumber = parseNumber(prev);
    int currNumber = parseNumber(curr);
    if (prevNumber == 0) {
      return false;
    }
    int combined = prevNumber * 10 + currNumber;
    return 1 <= combined && combined <= 34;
  }

  private static int parseNumber(int index) {
    return target.charAt(index) - '0';
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    target = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
