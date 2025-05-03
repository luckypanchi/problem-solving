import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] startBoard;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < 4; i++) {
      answer = Math.max(answer, solve(0, startBoard, i));
    }

    sb.append(answer);

    output();
  }

  private static int solve(int curr, int[][] currBoard, int d) {
    if (curr == 5) {
      return getMax(currBoard);
    }

    int[][] board = copyBoard(currBoard);
    boolean[][] isCombined = new boolean[n][n];

    if (d == 0) {
      goRight(board, isCombined);
    } else if (d == 1) {
      goDown(board, isCombined);
    } else if (d == 2) {
      goLeft(board, isCombined);
    } else if (d == 3) {
      goUp(board, isCombined);
    }

    int result = 0;
    for (int i = 0; i < 4; i++) {
      result = Math.max(result, solve(curr + 1, board, i));
    }

    return result;
  }

  private static void goUp(int[][] board, boolean[][] isCombined) {
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < n; i++) {
        if (board[i][j] != 0) {
          int number = board[i][j];
          board[i][j] = 0;
          for (int k = i; k > -1; k--) {
            if (board[k][j] == number && !isCombined[k][j]) {
              board[k][j] = 2 * number;
              isCombined[k][j] = true;
              break;
            } else if (board[k][j] != 0) {
              board[k + 1][j] = number;
              break;
            } else if (k == 0) {
              board[k][j] = number;
              break;
            }
          }
        }
      }
    }
  }

  private static void goLeft(int[][] board, boolean[][] isCombined) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != 0) {
          int number = board[i][j];
          board[i][j] = 0;
          for (int k = j; k > -1; k--) {
            if (board[i][k] == number && !isCombined[i][k]) {
              board[i][k] = 2 * number;
              isCombined[i][k] = true;
              break;
            } else if (board[i][k] != 0) {
              board[i][k + 1] = number;
              break;
            } else if (k == 0) {
              board[i][k] = number;
              break;
            }
          }
        }
      }
    }
  }

  private static void goDown(int[][] board, boolean[][] isCombined) {
    for (int j = 0; j < n; j++) {
      for (int i = n - 1; i > -1; i--) {
        if (board[i][j] != 0) {
          int number = board[i][j];
          board[i][j] = 0;
          for (int k = i; k < n; k++) {
            if (board[k][j] == number && !isCombined[k][j]) {
              board[k][j] = 2 * number;
              isCombined[k][j] = true;
              break;
            } else if (board[k][j] != 0) {
              board[k - 1][j] = number;
              break;
            } else if (k == n - 1) {
              board[k][j] = number;
              break;
            }
          }
        }
      }
    }
  }

  private static void goRight(int[][] board, boolean[][] isCombined) {
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j > -1; j--) {
        if (board[i][j] != 0) {
          int number = board[i][j];
          board[i][j] = 0;
          for (int k = j; k < n; k++) {
            if (board[i][k] == number && !isCombined[i][k]) {
              board[i][k] = 2 * number;
              isCombined[i][k] = true;
              break;
            } else if (board[i][k] != 0) {
              board[i][k - 1] = number;
              break;
            } else if (k == n - 1) {
              board[i][k] = number;
              break;
            }
          }
        }
      }
    }
  }

  private static int getMax(int[][] board) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, board[i][j]);
      }
    }
    return max;
  }

  private static int[][] copyBoard(int[][] board) {
    int[][] newBoard = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newBoard[i][j] = board[i][j];
      }
    }
    return newBoard;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    startBoard = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        startBoard[i][j] = Integer.parseInt(st.nextToken());
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