import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    int start = 0;
    int end = 1;
    int answer = 0;
    while (end < n + 1) {
      int s = prefixSum[end] - prefixSum[start];
      if (s == m) {
        answer++;
        start++;
      } else if (s < m) {
        end++;
      } else {
        start++;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    prefixSum = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}