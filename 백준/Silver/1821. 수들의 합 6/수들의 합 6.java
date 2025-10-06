import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, f;
  static boolean[] isSelected;
  static int[][] sum;

  public static void main(String[] args) throws IOException {
    setUp();

    combination(1);

    output();
  }

  private static boolean check() {
    for (int depth = 1; depth < n; depth++) {
      for (int i = 1; i < n + 1 - depth; i++) {
        sum[depth][i] = sum[depth - 1][i] + sum[depth - 1][i + 1];
      }
    }

    return sum[n - 1][1] == f;
  }

  private static boolean combination(int curr) {
    if (curr == n + 1) {
      if (check()) {
        for (int i = 1; i < n + 1; i++) {
          sb.append(sum[0][i]).append(" ");
        }
        return true;
      }
      return false;
    }

    for (int i = 1; i < n + 1; i++) {
      if (isSelected[i]) {
        continue;
      }

      sum[0][curr] = i;
      isSelected[i] = true;
      if (combination(curr + 1)) {
        return true;
      }
      isSelected[i] = false;
      sum[0][curr] = 0;
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    f = Integer.parseInt(st.nextToken());
    sum = new int[n][n + 1];
    isSelected = new boolean[n + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}