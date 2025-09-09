import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static long a, b;
  static final int MOD = 1_000_000_000;
  static Map<Long, Long> map;

  public static void main(String[] args) throws IOException {
    setUp();

    map.put(0L, 0L);
    map.put(1L, 1L);
    map.put(2L, 1L);
    map.put(3L, 2L);

    sb.append((f(b + 2) - f(a + 1) + MOD) % MOD);

    output();
  }

  private static long f(long n) {
    if (map.containsKey(n)) {
      return map.get(n);
    }

    if (n % 2 == 0) {
      long f1 = f(n / 2 + 1) % MOD;
      long f2 = f(n / 2 - 1) % MOD;
      map.put(n, (f1 * f1 % MOD - f2 * f2 % MOD + MOD) % MOD);
    } else {
      long f1 = f(n / 2) % MOD;
      long f2 = f(n / 2 + 1) % MOD;
      map.put(n, (f1 * f1 % MOD + f2 * f2 % MOD) % MOD);
    }

    return map.get(n);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());
    map = new HashMap<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}