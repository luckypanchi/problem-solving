import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] candyInfo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
      if (n == 0 && m == 0.0) {
        break;
      }

      candyInfo = new int[n][2];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        candyInfo[i][0] = Integer.parseInt(st.nextToken());
        candyInfo[i][1] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
      }

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int[] dp = new int[m + 1];

    for (int[] candy : candyInfo) {
      int calorie = candy[0];
      int price = candy[1];

      for (int target = price; target < m + 1; target++) {
        dp[target] = Math.max(dp[target], dp[target - price] + calorie);
      }
    }

    return dp[m];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}