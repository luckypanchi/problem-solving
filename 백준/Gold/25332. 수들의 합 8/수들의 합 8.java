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
  static int n;
  static int[] prefixSum, a, b;
  static Map<Integer, Integer> counter;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = 0L;
    for (int i = n; i > 0; i--) {
      int curr = prefixSum[i];

      if (curr == 0) {
        answer++;
      }

      answer += counter.getOrDefault(curr, 0);
      counter.put(curr, counter.getOrDefault(curr, 0) + 1);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    prefixSum = new int[n + 1];
    a = new int[n + 1];
    b = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < n + 1; i++) {
      prefixSum[i] = prefixSum[i - 1] + a[i] - b[i];
    }

    counter = new HashMap<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}