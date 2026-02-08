import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] weights;
  static int[] marbles;
  static boolean[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new boolean[40_001];
    dp[0] = true;

    for (int i = n - 1; i > -1; i--) {
      int w = weights[i];
      List<Integer> tmp = new ArrayList<>();
      for (int j = 0; j < 40_001; j++) {
        if (!dp[j]) {
          continue;
        }

        if (j + w < 40_001) {
          tmp.add(j + w);
        }
        if (0 < j - w) {
          tmp.add(j - w);
        }
        if (0 < w - j) {
          tmp.add(w - j);
        }
      }

      for (int nxt : tmp) {
        dp[nxt] = true;
      }
    }

    for (int i = 0; i < m; i++) {
      if (dp[marbles[i]]) {
        sb.append("Y").append(" ");
      } else {
        sb.append("N").append(" ");
      }
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    weights = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }
    m = Integer.parseInt(br.readLine());
    marbles = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      marbles[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}