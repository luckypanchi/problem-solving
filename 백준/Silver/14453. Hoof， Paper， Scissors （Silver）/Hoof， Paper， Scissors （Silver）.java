import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] suffixSumList;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = Integer.MIN_VALUE;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 1; k < n + 1; k++) {
          answer = Math.max(answer, suffixSumList[i][k] + suffixSumList[j][n] - suffixSumList[j][k]);
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    suffixSumList = new int[3][n + 1];

    for (int i = 1; i < n + 1; i++) {
      char curr = br.readLine().charAt(0);
      if (curr == 'P') {
        suffixSumList[0][i] = 1;
      } else if (curr == 'H') {
        suffixSumList[1][i] = 1;
      } else if (curr == 'S') {
        suffixSumList[2][i] = 1;
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 1; j < n + 1; j++) {
        suffixSumList[i][j] += suffixSumList[i][j - 1];
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