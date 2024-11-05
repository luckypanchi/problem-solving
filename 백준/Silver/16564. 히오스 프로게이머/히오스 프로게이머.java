import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long k;
  static long[] levels;

  public static void main(String[] args) throws IOException {
    setUp();

    long left = Arrays.stream(levels).min().getAsLong();
    long right = Arrays.stream(levels).max().getAsLong() + k;
    long answer = -1;

    while (left <= right) {
      long mid = (left + right) / 2;
      if (check(mid) <= k) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    sb.append(answer);
    output();
  }

  private static long check(long target) {
    long sum = 0;
    for (long level : levels) {
      if (target <= level) {
        continue;
      }
      sum += target - level;
    }
    return sum;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Long.parseLong(st.nextToken());
    levels = new long[n];
    for (int i = 0; i < n; i++) {
      levels[i] = Long.parseLong(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}