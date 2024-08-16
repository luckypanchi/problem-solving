import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, b, c, d, e, f;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int x = -999; x < 1000; x++) {
      for (int y = -999; y < 1000; y++) {
        if (f1(x, y) == 0 && f2(x, y) == 0) {
          sb.append(x).append(" ").append(y);
        }
      }
    }

    output();
  }

  private static int f2(int x, int y) {
    return d * x + e * y - f;
  }

  private static int f1(int x, int y) {
    return a * x + b * y - c;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    f = Integer.parseInt(st.nextToken());

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}