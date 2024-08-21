import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String target;
  static final int MOD = 1_000_000_007;
  static int[] eCount;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = n - 1; i >= 0; i--) {
      eCount[i] = eCount[i + 1];
      if (target.charAt(i) == 'E') {
        eCount[i]++;
      }
    }

    int wCount = 0;
    long answer = 0;
    for (int i = 0; i < n; i++) {
      if (target.charAt(i) == 'W') {
        wCount++;
      } else if (target.charAt(i) == 'H') {
        long powResult = (pow(2, eCount[i]) - eCount[i] - 1 + MOD) % MOD;
        answer = (answer + wCount * powResult) % MOD;
      }
    }

    sb.append(answer);

    output();
  }

  private static long pow(int r, int c) {
    if (c == 0) {
      return 1;
    }
    if (c == 1) {
      return r;
    }

    long result = pow(r, c / 2) % MOD;
    result = (result * result) % MOD;

    if (c % 2 != 0) {
      result = (result * r) % MOD;
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    target = br.readLine();
    eCount = new int[n + 1];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}