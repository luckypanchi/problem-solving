import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[][] buckets;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(buckets, Comparator.comparing(o -> o[1]));

    int start = 0;
    int end = 1;
    int curr = buckets[0][0];
    int answer = 0;

    while (end < n) {
      if (buckets[end][1] - buckets[start][1] <= 2 * k) {
        curr += buckets[end][0];
        end++;
      } else {
        curr -= buckets[start][0];
        start++;
      }

      answer = Math.max(answer, curr);
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    buckets = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      buckets[i][0] = Integer.parseInt(st.nextToken());
      buckets[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}