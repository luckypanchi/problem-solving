import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] xList;
  static int[] yList;
  static int[] answers;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int targetX : xList) {
      for (int targetY : yList) {
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
          distances[i] = Math.abs(targetX - xList[i]) + Math.abs(targetY - yList[i]);
        }

        Arrays.sort(distances);

        int sum = 0;
        for (int i = 0; i < n; i++) {
          sum += distances[i];
          answers[i] = Math.min(answers[i], sum);
        }

      }
    }

    for (int ans : answers) {
      sb.append(ans).append(" ");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    xList = new int[n];
    yList = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      xList[i] = Integer.parseInt(st.nextToken());
      yList[i] = Integer.parseInt(st.nextToken());
    }
    answers = new int[n];
    Arrays.fill(answers, Integer.MAX_VALUE);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}