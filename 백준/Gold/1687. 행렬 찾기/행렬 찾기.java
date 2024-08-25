import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int col1 = 1; col1 < m + 1; col1++) {
      for (int col2 = col1; col2 < m + 1; col2++) {
        int count = 0;
        for (int row = 1; row < n + 1; row++) {
          if (prefixSum[row][col2] - prefixSum[row][col1 - 1] == col2 - col1 + 1) {
            count += col2 - col1 + 1;
            answer = Math.max(answer, count);
          } else {
            count = 0;
          }
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    prefixSum = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      String line = br.readLine();
      for (int j = 1; j < m + 1; j++) {
        prefixSum[i][j] = 1 - (line.charAt(j - 1) - '0');
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        prefixSum[i][j] += prefixSum[i][j - 1];
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