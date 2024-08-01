import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String string1, string2;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    createDp();

    int i = string1.length();
    int j = string2.length();
    List<Character> answer = new ArrayList<>();
    while (dp[i][j] != 0) {
      if (dp[i][j] == dp[i - 1][j]) {
        i--;
      } else if (dp[i][j] == dp[i][j - 1]) {
        j--;
      } else {
        answer.add(string1.charAt(i - 1));
        i--;
        j--;
      }
    }

    Collections.reverse(answer);
    sb.append(dp[string1.length()][string2.length()]).append("\n");
    answer.forEach(c -> sb.append(c));

    output();
  }

  private static void createDp() {
    for (int i = 0; i < string1.length() + 1; i++) {
      for (int j = 0; j < string2.length() + 1; j++) {
        if (i == 0 || j == 0) {
          continue;
        }

        if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    string1 = br.readLine();
    string2 = br.readLine();
    dp = new int[string1.length() + 1][string2.length() + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}