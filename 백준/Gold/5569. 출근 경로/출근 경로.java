import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int w, h;
  static int[] dx = new int[]{1, 0};
  static int[] dy = new int[]{0, 1};
  static final int MOD = 100000;
  static int[][][][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = (solve(1, 2, 0, 0) + solve(2, 1, 0, 1)) % MOD;

    sb.append(answer);
    output();
  }

  private static int solve(int y, int x, int isTurned, int direction) {
    if (y <= 0 || h < y || x <= 0 || w < x) {
      return 0;
    }
    if (y == h && x == w) {
      return 1;
    }
    if (dp[y][x][isTurned][direction] != -1) {
      return dp[y][x][isTurned][direction];
    }

    int result = 0;
    if (isTurned == 1) {
      result = solve(y + dy[direction], x + dx[direction], 0, direction) % MOD;
    } else {
      result = (result + solve(y + dy[direction], x + dx[direction], 0, direction)) % MOD;
      int newDirection = 1 - direction;
      result = (result + solve(y + dy[newDirection], x + dx[newDirection], 1, newDirection)) % MOD;
    }

    dp[y][x][isTurned][direction] = result;
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    dp = new int[h + 1][w + 1][2][2];
    for (int i = 0; i < h + 1; i++) {
      for (int j = 0; j < w + 1; j++) {
        for (int k = 0; k < 2; k++) {
          Arrays.fill(dp[i][j][k], -1);
        }
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