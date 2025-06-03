import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, length;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = checkAllRows() + checkAllColumns();

    sb.append(answer);
    output();
  }

  private static int checkAllRows() {
    int result = 0;

    for (int row = 0; row < n; row++) {
      if (checkRow(row)) {
        result++;
      }
    }

    return result;
  }

  private static int checkAllColumns() {
    int result = 0;

    for (int col = 0; col < n; col++) {
      if (checkCol(col)) {
        result++;
      }
    }

    return result;
  }

  private static boolean checkRow(int row) {
    int prevHeight = board[row][0];
    boolean[] isOccupied = new boolean[n];
    for (int col = 1; col < n; col++) {
      if (prevHeight == board[row][col]) {
        continue;
      }

      if (Math.abs(prevHeight - board[row][col]) > 1) {
        return false;
      }

      // 현재 칸이 이전 칸보다 높은 경우 -> 이전 칸에 경사로를 둬야 한다.
      if (prevHeight < board[row][col]) {
        int targetHeight = prevHeight;
        for (int i = 0; i < length; i++) {
          int targetCol = col - 1 - i;
          if (targetCol < 0 || board[row][targetCol] != targetHeight || isOccupied[targetCol]) {
            return false;
          }
        }
        for (int i = 0; i < length; i++) {
          isOccupied[col - 1 - i] = true;
        }
      }

      // 현재 칸이 이전 칸보다 낮은 경우 -> 현재 칸에 경사로를 둬야 한다.
      if (prevHeight > board[row][col]) {
        int targetHeight = board[row][col];
        for (int i = 0; i < length; i++) {
          int targetCol = col + i;
          if (targetCol >= n || board[row][targetCol] != targetHeight || isOccupied[targetCol]) {
            return false;
          }
        }
        for (int i = 0; i < length; i++) {
          isOccupied[col + i] = true;
        }
      }

      prevHeight = board[row][col];
    }

    return true;
  }

  private static boolean checkCol(int col) {
    int prevHeight = board[0][col];
    boolean[] isOccupied = new boolean[n];
    for (int row = 1; row < n; row++) {
      if (prevHeight == board[row][col]) {
        continue;
      }

      if (Math.abs(prevHeight - board[row][col]) > 1) {
        return false;
      }

      // 현재 칸이 이전 칸보다 높은 경우
      if (prevHeight < board[row][col]) {
        int targetHeight = prevHeight;
        for (int i = 0; i < length; i++) {
          int targetRow = row - 1 - i;
          if (targetRow < 0 || board[targetRow][col] != targetHeight || isOccupied[targetRow]) {
            return false;
          }
        }
        for (int i = 0; i < length; i++) {
          isOccupied[row - 1 - i] = true;
        }
      }

      // 현재 칸이 이전 칸보다 낮은 경우
      if (prevHeight > board[row][col]) {
        int targetHeight = board[row][col];
        for (int i = 0; i < length; i++) {
          int targetRow = row + i;
          if (targetRow >= n || board[targetRow][col] != targetHeight || isOccupied[targetRow]) {
            return false;
          }
        }
        for (int i = 0; i < length; i++) {
          isOccupied[row + i] = true;
        }
      }

      prevHeight = board[row][col];
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    length = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
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