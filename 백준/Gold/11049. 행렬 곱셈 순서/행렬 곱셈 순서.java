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
  static Matrix[] matrices;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    sb.append(dfs(0, n - 1));

    output();
  }

  private static long dfs(int start, int end) {
    if (start == end) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    long result = Long.MAX_VALUE;
    for (int mid = start; mid < end; mid++) {
      result = Math.min(result, matrices[start].row * matrices[mid].col * matrices[end].col + dfs(start, mid) + dfs(mid + 1, end));
    }

    dp[start][end] = result;
    return dp[start][end];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    matrices = new Matrix[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      long row = Long.parseLong(st.nextToken());
      long col = Long.parseLong(st.nextToken());
      matrices[i] = new Matrix(row, col);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Matrix {

    long row;
    long col;

    public Matrix(long row, long col) {
      this.row = row;
      this.col = col;
    }
  }

}