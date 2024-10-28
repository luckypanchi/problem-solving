import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static final int LENGTH = 10_000_0001;

  public static void main(String[] args) throws IOException {
    setUp();

    boolean[] isPrime = getPrimeList();

    int count = 1;
    for (int i = 1; i < LENGTH; i++) {
      if (!isPrime[i]) {
        continue;
      }

      if (count == n) {
        sb.append(i);
        break;
      }
      count++;
    }

    output();
  }

  private static boolean[] getPrimeList() {
    boolean[] sieve = new boolean[LENGTH];
    Arrays.fill(sieve, true);

    sieve[0] = false;
    sieve[1] = false;

    for (int i = 2; i < Math.sqrt(LENGTH) + 1; i++) {
      if (sieve[i]) {
        for (int j = i * i; j < LENGTH; j += i) {
          sieve[j] = false;
        }
      }
    }

    return sieve;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}