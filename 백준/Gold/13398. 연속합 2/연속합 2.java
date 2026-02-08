import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] dp = new int[n][2];
    dp[0][0] = numbers[0];
    dp[0][1] = numbers[0];

    int answer = numbers[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(numbers[i], dp[i - 1][0] + numbers[i]);
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + numbers[i]);

      answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}