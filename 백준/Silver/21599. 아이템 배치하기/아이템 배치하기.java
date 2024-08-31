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
  static int[] items;
  static int[] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n; i++) {
      prefixSum[i] += 1;
      prefixSum[Math.min(i + items[i], n)] -= 1;
    }
    for (int i = 1; i < n + 1; i++) {
      prefixSum[i] += prefixSum[i - 1];
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (prefixSum[i] != 0) {
        count++;
      }
    }

    sb.append(count);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    items = new int[n];
    prefixSum = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      items[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(items);
    for (int i = 0; i < items.length / 2; i++) {
      int tmp = items[i];
      items[i] = items[n - 1 - i];
      items[n - 1 - i] = tmp;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}