import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] board;
  static int total;

  static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
  static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int y = 1; y < n - 1; y++) {
      for (int x = 1; x < n - 1; x++) {
        if (checkNoMineAround(y, x)) {
          total--;
          continue;
        }

        for (int i = 0; i < 8; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];

          board[ny][nx]--;
        }

      }
    }

    sb.append(total);
    output();
  }

  private static boolean checkNoMineAround(int y, int x) {
    for (int i = 0; i < 8; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (board[ny][nx] == 0) {
        return true;
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        char curr = line.charAt(j);
        if (curr == '#') {
          total++;
          board[i][j] = -1;
        } else {
          board[i][j] = curr - '0';
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