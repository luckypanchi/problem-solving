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

    int answer = Integer.MIN_VALUE;
    for (int rowLength = 1; rowLength < n + 1; rowLength++) {
      for (int colLength = 1; colLength < m + 1; colLength++) {
        answer = Math.max(answer, calc(rowLength, colLength));
      }
    }

    sb.append(answer);

    output();
  }

  private static int calc(int rowLength, int colLength) {
    int result = Integer.MIN_VALUE;

    for (int i = rowLength; i < n + 1; i++) {
      for (int j = colLength; j < m + 1; j++) {
        result = Math.max(result,
            prefixSum[i][j]
                - prefixSum[i - rowLength][j]
                - prefixSum[i][j - colLength]
                + prefixSum[i - rowLength][j - colLength]);
      }
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    prefixSum = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < m + 1; j++) {
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
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