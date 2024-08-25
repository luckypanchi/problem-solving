import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][][] counter;
  static int x1, y1, x2, y2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    counter = new int[n + 1][n + 1][11];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
        int number = Integer.parseInt(st.nextToken());
        counter[i][j][number] += 1;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        for (int k = 0; k < 11; k++) {
          counter[i][j][k] += counter[i - 1][j][k] + counter[i][j - 1][k] - counter[i - 1][j - 1][k];
        }
      }
    }

    int queries = Integer.parseInt(br.readLine());
    for (int q = 0; q < queries; q++) {
      st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());
      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int result = 0;
    for (int target = 1; target < 11; target++) {
      int count = counter[x2][y2][target] - counter[x1 - 1][y2][target] - counter[x2][y1 - 1][target] + counter[x1 - 1][y1 - 1][target];
      if (count != 0) {
        result++;
      }
    }

    return result;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}