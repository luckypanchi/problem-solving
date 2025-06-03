import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, answer;
  static int[][] board;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    combination(0, 0);

    sb.append(answer);
    output();
  }

  private static void combination(int curr, int start) {
    if (curr == n / 2) {

      int sum1 = 0;
      int sum2 = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (isSelected[i] && isSelected[j]) {
            sum1 += board[i][j];
          } else if (!isSelected[i] && !isSelected[j]) {
            sum2 += board[i][j];
          }
        }
      }

      answer = Math.min(answer, Math.abs(sum1 - sum2));

      return;
    }

    for (int i = start; i < n; i++) {
      isSelected[i] = true;

      combination(curr + 1, i + 1);

      isSelected[i] = false;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    answer = Integer.MAX_VALUE;
    isSelected = new boolean[n];
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