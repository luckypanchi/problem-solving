import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] isFront;
  static final int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    setUp();

    int backCount = Arrays.stream(isFront).sum();
    long answer =
        (pow(m - 1, backCount)
            + (n - backCount) * pow(m - 1, backCount + 1) % MOD
            + backCount * pow(m - 1, backCount - 1) % MOD) % MOD;

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
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    isFront = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      isFront[i] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}