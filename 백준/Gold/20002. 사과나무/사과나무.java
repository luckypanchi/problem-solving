import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] board;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
      }
    }

    int answer = Integer.MIN_VALUE;
    for (int length = 1; length < n + 1; length++) {
      for (int i = length; i < n + 1; i++) {
        for (int j = length; j < n + 1; j++) {
          int curr = board[i][j] - board[i - length][j] - board[i][j - length] + board[i - length][j - length];
          answer = Math.max(answer, curr);
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    board = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
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