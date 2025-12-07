import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] points;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = 0;
    for (int i = 0; i < n; i++) {
      answer -= (long) points[i][0] * points[i + 1][1];
    }
    for (int i = 1; i < n + 1; i++) {
      answer += (long) points[i][0] * points[i - 1][1];
    }
    sb.append(String.format("%.1f", Math.abs(answer) * 0.5));

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    points = new int[n + 1][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      points[i][0] = Integer.parseInt(st.nextToken());
      points[i][1] = Integer.parseInt(st.nextToken());
    }
    points[n] = points[0];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}