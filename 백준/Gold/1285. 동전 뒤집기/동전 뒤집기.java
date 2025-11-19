import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static char[][] board;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = n * n;
    for (int rowCase = 0; rowCase < (1 << n); rowCase++) {
      int count = 0;
      for (int col = 0; col < n; col++) {
        int backCount = 0;
        for (int row = 0; row < n; row++) {
          char curr = board[row][col];
          if ((rowCase & (1 << row)) != 0) {
            curr = flip(curr);
          }

          if (curr == 'T') {
            backCount++;
          }
        }
        count += Math.min(backCount, n - backCount);
      }
      answer = Math.min(answer, count);
    }

    sb.append(answer);
    output();
  }

  private static char flip(char c) {
    if (c == 'H') {
      return 'T';
    }
    return 'H';
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    board = new char[n][n];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = row.charAt(j);
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