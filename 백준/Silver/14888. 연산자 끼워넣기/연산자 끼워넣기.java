import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;
  static int[] counts;
  static int max, min;

  public static void main(String[] args) throws IOException {
    setUp();

    dfs(numbers[0], 1);

    sb.append(max).append("\n").append(min);

    output();
  }

  private static void dfs(int prev, int curr) {
    if (curr == n) {
      max = Math.max(prev, max);
      min = Math.min(prev, min);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (counts[i] != 0) {
        counts[i]--;

        if (i == 0) {
          dfs(prev + numbers[curr], curr + 1);
        } else if (i == 1) {
          dfs(prev - numbers[curr], curr + 1);
        } else if (i == 2) {
          dfs(prev * numbers[curr], curr + 1);
        } else {
          dfs(prev / numbers[curr], curr + 1);
        }

        counts[i]++;
      }
    }

  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    counts = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      counts[i] = Integer.parseInt(st.nextToken());
    }
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}