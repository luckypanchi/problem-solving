import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static String lock;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n - 1; i++) {
      char curr = lock.charAt(i);
      if (curr == 'A') {
        sb.append('A');
        continue;
      }
      if ('Z' - curr + 1 <= k) {
        k -= 'Z' - curr + 1;
        sb.append('A');
      } else {
        sb.append(curr);
      }
    }

    k %= 26;
    char last = lock.charAt(n - 1);
    if ('Z' - last + 1 <= k) {
      k -= 'Z' - last + 1;
      last = (char) ('A' + k);
    } else {
      last = (char) (last + k);
    }

    sb.append(last);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    lock = br.readLine();

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}