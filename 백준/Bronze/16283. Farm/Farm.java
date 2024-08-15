import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, b, n, w;

  public static void main(String[] args) throws IOException {
    setUp();

    List<int[]> answers = new ArrayList<>();
    for (int sheep = 1; sheep < n; sheep++) {
      int goat = n - sheep;
      if (a * sheep + b * goat == w) {
        answers.add(new int[]{sheep, goat});
      }

    }

    if (answers.size() == 0 || answers.size() >= 2) {
      sb.append(-1);
    } else {
      int[] answer = answers.get(0);
      sb.append(answer[0]).append(" ").append(answer[1]);
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}