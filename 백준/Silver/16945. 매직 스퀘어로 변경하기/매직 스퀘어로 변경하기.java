import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int answer;
  static int[][] board, newBoard;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    solve(0, 0);

    sb.append(answer);

    output();
  }

  private static void solve(int curr, int prevCost) {
    if (curr == 9) {
      if (check()) {
        answer = Math.min(answer, prevCost);
      }
      return;
    }

    int r = curr / 3;
    int c = curr % 3;

    for (int i = 1; i < 10; i++) {
      if (isSelected[i]) {
        continue;
      }

      isSelected[i] = true;
      newBoard[r][c] = i;
      solve(curr + 1, prevCost + Math.abs(board[r][c] - i));
      isSelected[i] = false;
    }

  }

  private static boolean check() {
    int sum = Arrays.stream(newBoard[0]).sum();

    for (int i = 0; i < 3; i++) {
      int rowSum = 0;
      int colSum = 0;
      for (int j = 0; j < 3; j++) {
        rowSum += newBoard[i][j];
        colSum += newBoard[j][i];
      }

      if (sum != rowSum || sum != colSum) {
        return false;
      }
    }

    int daegak1 = 0;
    int daegak2 = 0;
    for (int i = 0; i < 3; i++) {
      daegak1 += newBoard[i][i];
      daegak2 += newBoard[i][2 - i];
    }

    if (sum != daegak1 || sum != daegak2) {
      return false;
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    board = new int[3][3];
    newBoard = new int[3][3];
    isSelected = new boolean[10];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
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