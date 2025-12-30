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

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
      }
    }

    sb.append(solve());

    output();
  }

  private static int solve() {
    for (int length = Math.min(n, m); length > 0; length--) {
      for (int i = length; i < n + 1; i++) {
        for (int j = length; j < m + 1; j++) {
          int size = board[i][j] - board[i - length][j] - board[i][j - length] + board[i - length][j - length];
          if (size == length * length) {
            return size;
          }
        }
      }
    }
    return 0;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      String row = br.readLine();
      for (int j = 1; j < m + 1; j++) {
        board[i][j] = row.charAt(j - 1) - '0';
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