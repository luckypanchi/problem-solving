import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int n;
  static char[][] matrix;
  static int answer = Integer.MIN_VALUE;

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    matrix = new char[n][n];

    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < n; j++) {
        matrix[i][j] = row.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        getLength(i, j);
        solve(i, j);
      }
    }
    System.out.println(answer);
  }

  static void solve(int y, int x) {
    char currentColor = matrix[y][x];
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (
        0 <= ny && ny < n && 0 <= nx && nx < n && currentColor != matrix[ny][nx]
      ) {
        swap(y, x, ny, nx);
        getLength(y, x);
        swap(y, x, ny, nx);
      }
    }
  }

  static void swap(int fromY, int fromX, int toY, int toX) {
    char tmp = matrix[fromY][fromX];
    matrix[fromY][fromX] = matrix[toY][toX];
    matrix[toY][toX] = tmp;
  }

  static void getLength(int y, int x) {
    for (int i = 0; i < 2; i++) {
      int result =
        go(y, x, dy[i], dx[i], 0) + go(y, x, dy[i + 2], dx[i + 2], 0) + 1;
      answer = Math.max(answer, result);
    }
  }

  static int go(int y, int x, int dirY, int dirX, int length) {
    int ny = y + dirY;
    int nx = x + dirX;

    if (
      0 <= ny && ny < n && 0 <= nx && nx < n && matrix[y][x] == matrix[ny][nx]
    ) {
      return go(ny, nx, dirY, dirX, length + 1);
    } else {
      return length;
    }
  }
}
