import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static char[][] board;
  static int[][] positions;
  static int[] numbers;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    permutation(0);
    for (int i = 0; i < 12; i++) {
      int y = positions[i][0];
      int x = positions[i][1];
      board[y][x] = (char) ('A' + numbers[i] - 1);
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }

    output();
  }

  private static boolean permutation(int curr) {
    if (curr == 12) {
      return check();
    }

    if (numbers[curr] != -1) {
      return permutation(curr + 1);
    }

    for (int i = 1; i < 13; i++) {
      if (!isSelected[i]) {
        isSelected[i] = true;
        numbers[curr] = i;
        if (permutation(curr + 1)) {
          return true;
        }
        numbers[curr] = -1;
        isSelected[i] = false;
      }
    }

    return false;
  }

  private static boolean check() {
    int target = 26;
    int[][] indexes = new int[][]{
        {0, 2, 5, 7},
        {0, 3, 6, 10},
        {1, 2, 3, 4},
        {1, 5, 8, 11},
        {4, 6, 9, 11},
        {7, 8, 9, 10}
    };

    for (int[] index : indexes) {
      int s = 0;
      for (int i : index) {
        s += numbers[i];
      }
      if (s != target) {
        return false;
      }
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    board = new char[5][9];
    positions = new int[12][2];
    numbers = new int[12];
    isSelected = new boolean[13];
    int cursor = 0;
    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      for (int j = 0; j < 9; j++) {
        board[i][j] = line.charAt(j);
        if (board[i][j] != '.') {
          positions[cursor][0] = i;
          positions[cursor][1] = j;
          numbers[cursor] = board[i][j] == 'x' ? -1 : board[i][j] - 'A' + 1;
          cursor++;
        }
      }
    }

    for (int num : numbers) {
      if (num != -1) {
        isSelected[num] = true;
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