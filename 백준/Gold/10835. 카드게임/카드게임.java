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
  static int[] a, b;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(0, 0);
    sb.append(answer);

    output();
  }

  private static int dfs(int indexA, int indexB) {
    if (indexA == n || indexB == n) {
      return 0;
    }
    if (dp[indexA][indexB] != -1) {
      return dp[indexA][indexB];
    }

    int result = Math.max(dfs(indexA + 1, indexB), dfs(indexA + 1, indexB + 1));

    if (b[indexB] < a[indexA]) {
      result = Math.max(result, dfs(indexA, indexB + 1) + b[indexB]);
    }

    dp[indexA][indexB] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    a = new int[n];
    b = new int[n];
    dp = new int[n][n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}