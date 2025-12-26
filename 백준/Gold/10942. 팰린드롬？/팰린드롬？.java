import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] numbers;
  static int[][] questions;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int i = 0; i < m; i++) {
      int start = questions[i][0];
      int end = questions[i][1];
      sb.append(solve(start, end)).append("\n");
    }

    output();
  }

  private static int solve(int start, int end) {
    if (start == end) {
      return 1;
    }
    if (start + 1 == end) {
      return numbers[start] == numbers[end] ? 1 : 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    if (numbers[start] != numbers[end]) {
      dp[start][end] = 0;
    } else {
      dp[start][end] = solve(start + 1, end - 1);
    }

    return dp[start][end];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    m = Integer.parseInt(br.readLine());
    questions = new int[m][2];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      questions[i][0] = Integer.parseInt(st.nextToken());
      questions[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}