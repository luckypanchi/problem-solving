import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, p;
  static int[][] costs;
  static boolean[] isOn;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    long status = 0;
    int onCount = 0;
    for (int i = 0; i < n; i++) {
      if (isOn[i]) {
        status |= (1 << i);
        onCount++;
      }
    }

    int answer = -1;
    if (onCount != 0 || p == 0) {
      answer = dfs(status);
    }

    sb.append(answer);
    output();
  }

  private static int dfs(long status) {
    if (dp[(int) status] != -1) {
      return dp[(int) status];
    }

    List<Integer> offList = new ArrayList<>();
    List<Integer> onList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if ((status & (1 << i)) != 0) {
        onList.add(i);
      } else {
        offList.add(i);
      }
    }

    if (onList.size() >= p) {
      return 0;
    }

    int result = Integer.MAX_VALUE;

    for (int on : onList) {
      for (int off : offList) {
        result = Math.min(result, dfs(status | (1 << off)) + costs[on][off]);
      }
    }

    dp[(int) status] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    costs = new int[n][n];
    isOn = new boolean[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        costs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    String line = br.readLine();
    for (int i = 0; i < n; i++) {
      if (line.charAt(i) == 'Y') {
        isOn[i] = true;
      }
    }

    p = Integer.parseInt(br.readLine());

    dp = new int[(int) Math.pow(2, 16) + 1];
    Arrays.fill(dp, -1);

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}