import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static long x, y;

  public static void main(String[] args) throws IOException {
    setUp();

    if (y == x) {
      sb.append(-1);
    } else {
      sb.append(solve());
    }

    output();
  }

  private static int solve() {
    int curr = calc();

    if (curr == 99) {
      return -1;
    }

    return (int) Math.ceil((double) ((curr + 1) * x - 100 * y) / (99 - curr));
  }

  private static int calc() {
    return (int) (100 * y / x);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Long.parseLong(st.nextToken());
    y = Long.parseLong(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}