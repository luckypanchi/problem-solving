import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int X, Y, D, T;

  public static void main(String[] args) throws IOException {
    setUp();

    double distance = Math.sqrt(X * X + Y * Y);
    double result = distance;

    if (D <= T) {
      result = distance;
    } else if (D <= distance) {
      int jumpCount = (int) distance / D;
      result = Math.min(result, jumpCount * T + (distance - jumpCount * D));
      result = Math.min(result, (jumpCount + 1) * T);
    } else {
      result = Math.min(result, T + (D - distance));
      result = Math.min(result, 2 * T);
    }

    sb.append(result);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}