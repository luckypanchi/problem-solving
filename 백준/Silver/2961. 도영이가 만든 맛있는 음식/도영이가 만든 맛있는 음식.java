import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, answer;
  static int[][] gradients;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    subset(0, 0, 1, 0);

    sb.append(answer);
    output();
  }

  private static void subset(int curr, int count, int s, int b) {
    if (curr == n) {
      if (count == 0) {
        return;
      }
      answer = Math.min(answer, Math.abs(s - b));
      return;
    }

    subset(curr + 1, count, s, b);
    subset(curr + 1, count + 1, s * gradients[curr][0], b + gradients[curr][1]);
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    gradients = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      gradients[i][0] = Integer.parseInt(st.nextToken());
      gradients[i][1] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}