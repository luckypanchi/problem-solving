import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int w, h;
  static int toastX, toastY;
  static final long MOD = 1_000_007;

  public static void main(String[] args) throws IOException {
    setUp();

    long[][] dp = new long[200][200];
    for (int i = 0; i < 200; i++) {
      dp[i][0] = 1;
      dp[0][i] = 1;
    }

    for (int i = 1; i < 200; i++) {
      for (int j = 1; j < 200; j++) {
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
      }
    }

    long answer = (dp[toastY][toastX] * dp[h - toastY][w - toastX]) % MOD;
    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken()) - 1;
    h = Integer.parseInt(st.nextToken()) - 1;
    st = new StringTokenizer(br.readLine());
    toastX = Integer.parseInt(st.nextToken()) - 1;
    toastY = Integer.parseInt(st.nextToken()) - 1;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}