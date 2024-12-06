import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r, c, q;
  static int[][] prefixSum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    prefixSum = new int[r + 1][c + 1];
    for (int i = 1; i < r + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < c + 1; j++) {
        prefixSum[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i < r + 1; i++) {
      for (int j = 1; j < c + 1; j++) {
        prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
      }
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken());
      int c1 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      int count = (r2 - r1 + 1) * (c2 - c1 + 1);
      int sum = prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1] + prefixSum[r1 - 1][c1 - 1];
      sb.append(sum / count).append("\n");
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}