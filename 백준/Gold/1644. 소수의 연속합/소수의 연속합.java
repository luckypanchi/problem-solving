import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] primeList = getPrimeList();
    int left = 0;
    int right = 0;
    int sum = primeList[0];
    int answer = 0;
    while (right < primeList.length - 1) {
      if (sum <= n) {
        if (sum == n) {
          answer++;
        }
        right++;
        sum += primeList[right];
      } else {
        sum -= primeList[left];
        left++;
      }
    }

    sb.append(answer);

    output();
  }

  private static int[] getPrimeList() {
    boolean[] sieve = new boolean[n + 1];
    Arrays.fill(sieve, true);
    List<Integer> list = new ArrayList<>();

    for (int i = 2; i < n + 1; i++) {
      if (!sieve[i]) {
        continue;
      }

      list.add(i);
      for (int j = i + i; j < n + 1; j += i) {
        sieve[j] = false;
      }
    }
    list.add(0);

    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
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