import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r, c, t;
  static char[][] board;
  static int startY, startX;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    boolean[][] visited = new boolean[r][c];
    visited[startY][startX] = true;
    sb.append(solve(startY, startX, t, visited));

    output();
  }

  private static int solve(int currY, int currX, int count, boolean[][] visited) {
    if (count == 0) {
      return 0;
    }

    int result = 0;
    for (int i = 0; i < 4; i++) {
      int ny = currY + dy[i];
      int nx = currX + dx[i];

      if (!checkRange(ny, nx) || board[ny][nx] == '#' || visited[ny][nx]) {
        continue;
      }

      visited[ny][nx] = true;

      if (board[ny][nx] == 'S') {
        boolean[][] newVisited = new boolean[r][c];
        newVisited[ny][nx] = true;
        board[ny][nx] = '.';
        result = Math.max(result, solve(ny, nx, count - 1, newVisited) + 1);
        board[ny][nx] = 'S';
      } else {
        result = Math.max(result, solve(ny, nx, count - 1, visited));
      }

      visited[ny][nx] = false;
    }

    return result;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < r && 0 <= x && x < c;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    board = new char[r][c];
    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = row.charAt(j);
        if (board[i][j] == 'G') {
          startY = i;
          startX = j;
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