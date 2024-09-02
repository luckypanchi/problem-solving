import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int g;

  public static void main(String[] args) throws IOException {
    setUp();

    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i < Math.sqrt(g); i++) {
      if (g % i == 0 && (g / i + i) % 2 == 0) {
        answer.add((g / i + i) / 2);
      }
    }

    Collections.sort(answer);
    if (answer.isEmpty()) {
      sb.append(-1);
    } else {
      answer.forEach(num -> sb.append(num).append("\n"));
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    g = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}