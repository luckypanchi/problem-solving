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
  static int[][] papers;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(papers, (p1, p2) -> {
      if (p1[0] != p2[0]) {
        return p2[0] - p1[0];
      }
      return p2[1] - p1[1];
    });

    int[] dp = new int[n];
    dp[0] = 1;
    for (int curr = 1; curr < n; curr++) {
      dp[curr] = 1;
      for (int prev = curr - 1; prev > -1; prev--) {
        if (papers[curr][0] <= papers[prev][0] && papers[curr][1] <= papers[prev][1]) {
          dp[curr] = Math.max(dp[curr], dp[prev] + 1);
        }
      }

    }

    sb.append(Arrays.stream(dp).max().getAsInt());
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    papers = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int longer = Math.max(a, b);
      int shorter = Math.min(a, b);
      papers[i][0] = longer;
      papers[i][1] = shorter;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}