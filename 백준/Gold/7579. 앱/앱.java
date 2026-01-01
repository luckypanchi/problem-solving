import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] memories;
  static int[] costs;

  public static void main(String[] args) throws IOException {
    setUp();

    int totalCost = sum(costs);
    int[][] dp = new int[n + 1][totalCost + 1];
    int answer = Integer.MAX_VALUE;

    for (int i = 1; i < n + 1; i++) {
      for (int currCost = 0; currCost < totalCost + 1; currCost++) {
        if (costs[i] <= currCost) {
          dp[i][currCost] = Math.max(dp[i - 1][currCost], dp[i - 1][currCost - costs[i]] + memories[i]);
        } else {
          dp[i][currCost] = dp[i - 1][currCost];
        }

        if (m <= dp[i][currCost]) {
          answer = Math.min(answer, currCost);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static int sum(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    memories = new int[n + 1];
    costs = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      memories[i] = Integer.parseInt(st.nextToken());
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