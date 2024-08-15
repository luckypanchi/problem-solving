import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, b;

  public static void main(String[] args) throws IOException {
    setUp();

    int mid = -a;
    if (f(mid) == 0) {
      sb.append(mid);
    } else {
      int d = 1;
      while (f(mid + d) != 0) {
        d++;
      }
      sb.append(mid - d).append(" ").append(mid + d);
    }

    output();
  }

  private static int f(int x) {
    return x * x + 2 * a * x + b;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}