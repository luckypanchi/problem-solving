import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    int diff = Integer.MAX_VALUE;
    int answer = -1;
    for (int end = 0; end < 11; end++) {
      int s = prefixSum[end];
      if (Math.abs(100 - s) < diff) {
        diff = Math.abs(100 - s);
        answer = s;
      } else if (Math.abs(100 - s) == diff && answer < s) {
        answer = s;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    prefixSum = new int[11];
    for (int i = 0; i < 10; i++) {
      prefixSum[i + 1] = prefixSum[i] + Integer.parseInt(br.readLine());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}