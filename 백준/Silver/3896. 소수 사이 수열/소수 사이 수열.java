import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static final int MAX_LENGTH = 2_000_000;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] isPrime = getPrimeSieve();

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      int k = Integer.parseInt(br.readLine());

      if (isPrime[k]) {
        sb.append(0).append("\n");
      } else {
        sb.append(findEnd(k, isPrime) - findStart(k, isPrime)).append("\n");
      }
    }

    output();
  }

  private static int findEnd(int target, boolean[] isPrime) {
    int curr = target;
    while (!isPrime[curr]) {
      curr++;
    }
    return curr;
  }

  private static int findStart(int target, boolean[] isPrime) {
    int curr = target;
    while (!isPrime[curr]) {
      curr--;
    }
    return curr;
  }

  private static boolean[] getPrimeSieve() {
    boolean[] sieve = new boolean[MAX_LENGTH];
    Arrays.fill(sieve, true);

    sieve[0] = false;
    sieve[1] = false;

    for (int i = 2; i < Math.sqrt(MAX_LENGTH) + 1; i++) {
      if (sieve[i]) {
        for (int j = i * i; j < MAX_LENGTH; j += i) {
          sieve[j] = false;
        }
      }
    }

    return sieve;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}