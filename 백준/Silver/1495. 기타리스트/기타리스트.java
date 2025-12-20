import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, s, m;
  static int[] volumes;
  static boolean[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new boolean[n + 1][m + 1];
    dp[0][s] = true;
    for (int i = 1; i < n + 1; i++) {
      for (int currVol = 0; currVol < m + 1; currVol++) {
        if (0 <= currVol - volumes[i - 1] && dp[i - 1][currVol - volumes[i - 1]]) {
          dp[i][currVol] = true;
        } else if (currVol + volumes[i - 1] < m + 1 && dp[i - 1][currVol + volumes[i - 1]]) {
          dp[i][currVol] = true;
        }
      }
    }

    int answer = -1;
    for (int i = m; i >= 0; i--) {
      if (dp[n][i]) {
        answer = i;
        break;
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    volumes = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      volumes[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}