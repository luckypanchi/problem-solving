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
  static int[][] wires;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(wires, (o1, o2) -> o1[0] - o2[0]);

    dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (wires[j][1] < wires[i][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    sb.append(n - max(dp));
    output();
  }

  private static int max(int[] array) {
    int max = Integer.MIN_VALUE;
    for (int num : array) {
      max = Math.max(max, num);
    }
    return max;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    wires = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      wires[i][0] = Integer.parseInt(st.nextToken());
      wires[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}