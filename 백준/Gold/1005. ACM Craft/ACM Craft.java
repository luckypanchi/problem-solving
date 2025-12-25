import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int buildingCount, orderCount;
  static int[] timeCosts;
  static Map<Integer, List<Integer>> map;
  static int target;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());

    while (testcases-- > 0) {
      st = new StringTokenizer(br.readLine());
      buildingCount = Integer.parseInt(st.nextToken());
      orderCount = Integer.parseInt(st.nextToken());
      timeCosts = new int[buildingCount + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i < buildingCount + 1; i++) {
        timeCosts[i] = Integer.parseInt(st.nextToken());
      }
      map = new HashMap<>();
      for (int i = 1; i < buildingCount + 1; i++) {
        map.put(i, new ArrayList<>());
      }
      for (int i = 0; i < orderCount; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        map.get(to).add(from);
      }
      target = Integer.parseInt(br.readLine());
      dp = new int[buildingCount + 1];
      Arrays.fill(dp, -1);

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    return dfs(target);
  }

  private static int dfs(int curr) {
    if (dp[curr] != -1) {
      return dp[curr];
    }

    int result = timeCosts[curr];
    for (int from : map.get(curr)) {
      result = Math.max(result, timeCosts[curr] + dfs(from));
    }

    dp[curr] = result;
    return dp[curr];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}