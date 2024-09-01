import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static double coins;
  static int freezes, n;
  static int[] problems;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[n][3];
    if (problems[0] == 0) {
      dp[0][1] = 1;
    } else {
      dp[0][0] = 1;
    }

    for (int i = 1; i < n; i++) {
      if (problems[i] != 0) {
        for (int j = 0; j < freezes + 1; j++) {
          dp[i][j] = dp[i - 1][j] + 1;
        }
      } else {
        for (int j = 1; j < freezes + 1; j++) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < freezes + 1; j++) {
        answer = Math.max(answer, dp[i][j]);
      }
    }

    sb.append(answer).append("\n");
    sb.append(Arrays.stream(problems).max().getAsInt());

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    coins = Double.parseDouble(br.readLine());
    freezes = Math.min((int) (coins / 0.99), 2);
    n = Integer.parseInt(br.readLine());
    problems = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      problems[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}