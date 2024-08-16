import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      long n = Long.parseLong(br.readLine());
      if (check(n)) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
      sb.append("\n");
    }

    output();
  }

  private static boolean check(long n) {
    for (int i = 2; i < (int) Math.pow(10, 6) + 1; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}