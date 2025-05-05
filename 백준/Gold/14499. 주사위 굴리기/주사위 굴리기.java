import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, y, x, k;
  static int[][] board;
  static int[] directions;

  static int[] horizontal;
  static int[] vertical;

  static int horizontalTop;
  static int verticalTop;

  static int[] dx = {0, 1, -1, 0, 0};
  static int[] dy = {0, 0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < k; i++) {
      int d = directions[i];
      int ny = y + dy[d];
      int nx = x + dx[d];

      if (!checkRange(ny, nx)) {
        continue;
      }

      y = ny;
      x = nx;

      if (d == 1 || d == 2) {
        if (d == 1) {
          verticalTop = (verticalTop + 1) % 4;
        } else if (d == 2) {
          verticalTop = (verticalTop + 3) % 4;
        }
        sb.append(vertical[verticalTop]).append("\n");
        if (board[y][x] == 0) {
          board[y][x] = vertical[(verticalTop + 2) % 4];
        } else {
          vertical[(verticalTop + 2) % 4] = board[y][x];
          board[y][x] = 0;
        }
        horizontal[horizontalTop] = vertical[verticalTop];
        horizontal[(horizontalTop + 2) % 4] = vertical[(verticalTop + 2) % 4];
      } else if (d == 3 || d == 4) {
        if (d == 3) {
          horizontalTop = (horizontalTop + 1) % 4;
        } else if (d == 4) {
          horizontalTop = (horizontalTop + 3) % 4;
        }
        sb.append(horizontal[horizontalTop]).append("\n");
        if (board[y][x] == 0) {
          board[y][x] = horizontal[(horizontalTop + 2) % 4];
        } else {
          horizontal[(horizontalTop + 2) % 4] = board[y][x];
          board[y][x] = 0;
        }
        vertical[verticalTop] = horizontal[horizontalTop];
        vertical[(verticalTop + 2) % 4] = horizontal[(horizontalTop + 2) % 4];
      }
    }

    output();
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    directions = new int[k];
    horizontal = new int[4];
    vertical = new int[4];
    horizontalTop = 0;
    verticalTop = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      directions[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}