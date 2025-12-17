import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String string1, string2;
  static int length1, length2;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < length1 + 1; i++) {
      for (int j = 1; j < length2 + 1; j++) {
        if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    sb.append(dp[length1][length2]).append("\n");

    Deque<Character> stack = new ArrayDeque<>();
    int curr1 = length1;
    int curr2 = length2;

    while (dp[curr1][curr2] != 0) {
      if (dp[curr1][curr2] == dp[curr1 - 1][curr2]) {
        curr1--;
      } else if (dp[curr1][curr2] == dp[curr1][curr2 - 1]) {
        curr2--;
      } else {
        stack.push(string1.charAt(curr1 - 1));
        curr1--;
        curr2--;
      }
    }

    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    string1 = br.readLine();
    string2 = br.readLine();
    length1 = string1.length();
    length2 = string2.length();
    dp = new int[length1 + 1][length2 + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}