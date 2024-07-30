import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    dp = new long[65][10];
    for (int i = 0; i < 65; i++) {
      Arrays.fill(dp[i], -1);
    }

    int tc = Integer.parseInt(br.readLine());
    for (int i = 0; i < tc; i++) {
      int n = Integer.parseInt(br.readLine());
      long result = 0;
      for (int j = 0; j < 10; j++) {
        result += dfs(n, j);
      }
      sb.append(result).append("\n");
    }

    output();
  }

  private static long dfs(int curr, int num) {
    if (curr == 1) {
      return 1;
    }
    if (dp[curr][num] != -1) {
      return dp[curr][num];
    }

    long result = 0;
    for (int i = num; i < 10; i++) {
      result += dfs(curr - 1, i);
    }

    dp[curr][num] = result;
    return result;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}