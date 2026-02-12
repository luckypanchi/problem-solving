import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] moves;
  static int length;
  static int[][][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[5][5][length];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    sb.append(solve(0, 0, 0));

    output();
  }

  private static int solve(int left, int right, int curr) {
    if (curr == length) {
      return 0;
    }
    if (dp[left][right][curr] != -1) {
      return dp[left][right][curr];
    }

    dp[left][right][curr] = Math.min(
        solve(moves[curr], right, curr + 1) + cost(left, moves[curr]),
        solve(left, moves[curr], curr + 1) + cost(right, moves[curr]));

    return dp[left][right][curr];
  }

  private static int cost(int curr, int dest) {
    if (curr == 0) {
      return 2;
    }
    if (curr == dest) {
      return 1;
    }
    if (Math.abs(curr - dest) == 2) {
      return 4;
    }
    return 3;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    moves = new int[100_000];
    length = 0;
    while (true) {
      int curr = Integer.parseInt(st.nextToken());
      if (curr == 0) {
        break;
      }
      moves[length] = curr;
      length++;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}