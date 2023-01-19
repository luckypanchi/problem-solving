import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int r, c;
  static char[][] matrix;
  static int[][] count;

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    matrix = new char[r][c];
    count = new int[r][c];

    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
        matrix[i][j] = row.charAt(j);
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 'X') {
          for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (0 <= ny && ny < r && 0 <= nx && nx < c) {
              if (matrix[ny][nx] == '.') {
                count[i][j]++;
              }
            } else {
              count[i][j]++;
            }
          }
        }
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (count[i][j] >= 3) {
          matrix[i][j] = '.';
        }
      }
    }

    int startX = 0;
    int startY = 0;
    int endX = c - 1;
    int endY = r - 1;

    Loop:for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 'X') {
          break Loop;
        }
      }
      startY++;
    }

    Loop:for (int j = 0; j < c; j++) {
      for (int i = 0; i < r; i++) {
        if (matrix[i][j] == 'X') {
          break Loop;
        }
      }
      startX++;
    }

    Loop:for (int i = r - 1; i > -1; i--) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 'X') {
          break Loop;
        }
      }
      endY--;
    }

    Loop:for (int j = c - 1; j > -1; j--) {
      for (int i = 0; i < r; i++) {
        if (matrix[i][j] == 'X') {
          break Loop;
        }
      }
      endX--;
    }

    for (int i = startY; i < endY + 1; i++) {
      for (int j = startX; j < endX + 1; j++) {
        sb.append(matrix[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
