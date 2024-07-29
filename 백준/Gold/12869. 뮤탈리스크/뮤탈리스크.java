import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] scvs;
  static int[][][] dp;
  static int[][] attacks = {
      {9, 3, 1},
      {9, 1, 3},
      {3, 9, 1},
      {3, 1, 9},
      {1, 9, 3},
      {1, 3, 9}
  };

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(scvs[0], scvs[1], scvs[2]);
    sb.append(answer);

    output();
  }

  private static int dfs(int scv1, int scv2, int scv3) {
    if (scv1 == 0 && scv2 == 0 && scv3 == 0) {
      return 0;
    }
    if (dp[scv1][scv2][scv3] != -1) {
      return dp[scv1][scv2][scv3];
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 6; i++) {
      int next1 = Math.max(scv1 - attacks[i][0], 0);
      int next2 = Math.max(scv2 - attacks[i][1], 0);
      int next3 = Math.max(scv3 - attacks[i][2], 0);

      int count = dfs(next1, next2, next3) + 1;
      result = Math.min(result, count);
    }

    dp[scv1][scv2][scv3] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    scvs = new int[3];
    for (int i = 0; i < n; i++) {
      scvs[i] = Integer.parseInt(st.nextToken());
    }

    dp = new int[61][61][61];
    for (int i = 0; i < 61; i++) {
      for (int j = 0; j < 61; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}