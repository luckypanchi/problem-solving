import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;

  public static void main(String[] args) throws IOException {
    setUp();

    long left = 1;
    long right = (long) n * n;
    long answer = -1;

    while (left <= right) {
      long mid = (left + right) / 2;
      long c = count(mid);
      if (k <= c) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    sb.append(answer);

    output();
  }

  private static long count(long target) {
    long result = 0;
    for (int i = 1; i < n + 1; i++) {
      result += Math.min(target / i, n);
    }
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}