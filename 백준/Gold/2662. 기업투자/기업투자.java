import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] benefits, dp, investHistory;
  static int[] path;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[m + 1][n + 1];
    investHistory = new int[n + 1][m + 1];
    path = new int[m + 1];

    for (int company = 1; company < m + 1; company++) {
      for (int budget = 1; budget < n + 1; budget++) {
        for (int inputMoney = budget; inputMoney >= 0; inputMoney--) {
          if (dp[company][budget] < dp[company - 1][budget - inputMoney] + benefits[inputMoney][company]) {
            dp[company][budget] = dp[company - 1][budget - inputMoney] + benefits[inputMoney][company];
            investHistory[budget][company] = inputMoney;
          }
        }
      }
    }

    sb.append(dp[m][n]).append("\n");

    findHistory(n, m);
    for (int i = 1; i < m + 1; i++) {
      sb.append(path[i]).append(" ");
    }

    output();
  }

  private static void findHistory(int currBudget, int currCompany) {
    if (currCompany == 0) {
      return;
    }
    path[currCompany] = investHistory[currBudget][currCompany];
    findHistory(currBudget - investHistory[currBudget][currCompany], currCompany - 1);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    benefits = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      for (int j = 1; j < m + 1; j++) {
        benefits[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}