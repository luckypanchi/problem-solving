import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int sCount, bCount;
  static char front, back;
  static final int LIMIT = 5000000;

  public static void main(String[] args) throws IOException {
    setUp();

    boolean[] primeSieve = getPrimeSieve();
    for (int i = 1; i < n + 1; i++) {
      if (!primeSieve[i]) {
        bCount++;
        back = 'B';
      } else if (back == 'B') {
        bCount--;
        sCount += 2;
        back = 'S';
        swap(i);
      } else {
        sCount++;
        back = 'S';
        swap(i);
      }

      if (i == 1) {
        front = back;
      }
    }

    sb.append(bCount).append(" ").append(sCount);

    output();
  }

  private static void swap(int index) {
    if (index == 1 || index == 2) {
      front = back;
      return;
    }
    char tmp = front;
    front = back;
    back = tmp;
  }

  private static boolean[] getPrimeSieve() {
    boolean[] sieve = new boolean[LIMIT + 1];
    Arrays.fill(sieve, true);
    sieve[1] = false;

    for (int i = 2; i * i < LIMIT + 1; i++) {
      if (sieve[i]) {
        for (int j = i * i; j < LIMIT + 1; j += i) {
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
