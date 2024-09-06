import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;
  static int[][] rowPrefixSum;
  static int[][] colPrefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int x = 1; x < m + 1; x++) {
      for (int y = 1; y < n + 1; y++) {
        rowPrefixSum[y][x] = board[y][x] + rowPrefixSum[y - 1][x];
      }
    }

    for (int y = 1; y < n + 1; y++) {
      for (int x = 1; x < m + 1; x++) {
        colPrefixSum[y][x] = board[y][x] + colPrefixSum[y][x - 1];
      }
    }

    int answer = Integer.MIN_VALUE;
    for (int row1 = 1; row1 < n + 1; row1++) {
      for (int row2 = row1 + 1; row2 < n + 1; row2++) {
        for (int col1 = 1; col1 < m + 1; col1++) {
          for (int col2 = col1 + 1; col2 < m + 1; col2++) {
            answer = Math.max(answer, solve(row1, row2, col1, col2));
          }
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static int solve(int row1, int row2, int col1, int col2) {
    return rowPrefixSum[n][col1] + rowPrefixSum[n][col2] + colPrefixSum[row1][m] + colPrefixSum[row2][m]
        - board[row1][col1] - board[row2][col1] - board[row1][col2] - board[row2][col2] + (col2 - col1 - 1) * (row2 - row1 - 1);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < m + 1; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    rowPrefixSum = new int[n + 1][m + 1];
    colPrefixSum = new int[n + 1][m + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}