import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, answer;
  static int[][] colors;
  static int[] targetColor;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    solve(0, 0, 0, 0, 0);

    sb.append(answer);
    output();
  }

  private static void solve(int curr, int r, int g, int b, int count) {
    if (7 < count) {
      return;
    }
    if (curr == n) {
      if (1 < count) {
        int diff = Math.abs(targetColor[0] - r / count) + Math.abs(targetColor[1] - g / count) + Math.abs(targetColor[2] - b / count);
        answer = Math.min(answer, diff);
      }
      return;
    }

    solve(curr + 1, r + colors[curr][0], g + colors[curr][1], b + colors[curr][2], count + 1);
    solve(curr + 1, r, g, b, count);

  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    colors = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        colors[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    targetColor = new int[3];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      targetColor[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}