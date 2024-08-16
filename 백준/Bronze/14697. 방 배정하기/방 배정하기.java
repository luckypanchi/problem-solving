import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, b, c, n;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve());

    output();
  }

  private static int solve() {
    for (int i = 0; i < n / a + 1; i++) {
      for (int j = 0; j < n / b + 1; j++) {
        for (int k = 0; k < n / c + 1; k++) {
          if (a * i + b * j + c * k == n) {
            return 1;
          }
        }
      }
    }

    return 0;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}