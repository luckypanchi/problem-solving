import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] memorySizes;
  static int[] costs;

  public static void main(String[] args) throws IOException {
    setUp();

    int totalCost = Arrays.stream(costs).sum();
    int[][] dp = new int[n + 1][totalCost + 1];
    int answer = Integer.MAX_VALUE;

    for (int stuff = 1; stuff < n + 1; stuff++) {
      for (int currCost = 0; currCost < totalCost + 1; currCost++) {
        if (costs[stuff] <= currCost) {
          dp[stuff][currCost] = Math.max(dp[stuff - 1][currCost], memorySizes[stuff] + dp[stuff - 1][currCost - costs[stuff]]);
        } else {
          dp[stuff][currCost] = dp[stuff - 1][currCost];
        }

        if (m <= dp[stuff][currCost]) {
          answer = Math.min(answer, currCost);
        }
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
    memorySizes = new int[n + 1];
    costs = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      memorySizes[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}