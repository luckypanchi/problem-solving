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
  static int n, k;
  static int[] prefixSum;
  static Map<Integer, Integer> counter;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = 0;
    for (int i = n; i > 0; i--) {
      int curr = prefixSum[i];
      if (curr == k) {
        answer++;
      }

      answer += counter.getOrDefault(curr + k, 0);
      counter.put(curr, counter.getOrDefault(curr, 0) + 1);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    prefixSum = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
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