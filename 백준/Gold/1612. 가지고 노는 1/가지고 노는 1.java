import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;

  public static void main(String[] args) throws IOException {
    setUp();

    int s = 0;
    int answer = 0;
    Set<Integer> visited = new HashSet<>();

    while (true) {
      answer++;
      s = 10 * s + 1;
      s %= n;
      if (s == 0) {
        break;
      }

      if (visited.contains(s)) {
        answer = -1;
        break;
      }

      visited.add(s);
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}