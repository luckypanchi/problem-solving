import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static long cursor;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int q = Integer.parseInt(br.readLine());
    long plus = 0L;
    long mul = 1L;
    cursor = 1L;

    for (int tc = 0; tc < q; tc++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      if (x == 0) {
        plus += Integer.parseInt(st.nextToken());
      }
      if (x == 1) {
        int n = Integer.parseInt(st.nextToken());
        plus *= n;
        mul *= n;
      } else if (x == 2) {
        cursor += Integer.parseInt(st.nextToken());
      } else if (x == 3) {
        sb.append(mul * cursor + plus).append("\n");
      }
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}