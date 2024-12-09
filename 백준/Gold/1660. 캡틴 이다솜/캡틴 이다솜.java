import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] dp;
  static List<Integer> sizes;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[n + 1];
    Arrays.fill(dp, -1);

    sizes = new ArrayList<>();
    int triangleSize = 1;
    int triangleAdd = 2;
    int curr = 1;
    while (curr <= n) {
      sizes.add(curr);
      triangleSize += triangleAdd;
      curr += triangleSize;
      triangleAdd++;
    }

    sizes.sort((o1, o2) -> o2 - o1);

    sb.append(solve(n));
    output();
  }

  private static int solve(int curr) {
    if (curr < 0) {
      return (int) 1e9;
    }
    if (curr == 0) {
      return 0;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    int result = Integer.MAX_VALUE;
    for (int s : sizes) {
      result = Math.min(result, 1 + solve(curr - s));
    }

    dp[curr] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}