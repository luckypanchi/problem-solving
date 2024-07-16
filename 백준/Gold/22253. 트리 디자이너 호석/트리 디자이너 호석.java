import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] nodeNumbers;
  static Map<Integer, List<Integer>> graph;
  static Map<Integer, List<Integer>> tree;
  static int[][][] dp;
  static final int MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    nodeNumbers = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      nodeNumbers[i] = Integer.parseInt(st.nextToken());
    }
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    createDAG();

    dp = new int[n + 1][10][2];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < 10; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    int answer = (solveDfs(1, 0, 0) + solveDfs(1, nodeNumbers[1], 1)) % MOD;

    System.out.println(answer);
  }

  private static int solveDfs(int curr, int prevChosen, int isSelected) {
    List<Integer> nextNodes = tree.get(curr);
    if (nextNodes.isEmpty()) {
      return isSelected;
    }
    if (dp[curr][prevChosen][isSelected] != -1) {
      return dp[curr][prevChosen][isSelected];
    }

    int result = isSelected;
    for (int next : nextNodes) {
      if (prevChosen <= nodeNumbers[next]) {
        result = (result + solveDfs(next, nodeNumbers[next], 1)) % MOD;
      }
      result = (result + solveDfs(next, prevChosen, 0)) % MOD;
    }

    dp[curr][prevChosen][isSelected] = result;
    return result;
  }

  private static void createDAG() {
    tree = new HashMap<>();
    for (int i = 0; i < n + 1; i++) {
      tree.put(i, new ArrayList<>());
    }

    dagDfs(1, 0);
  }

  private static void dagDfs(int curr, int prev) {
    for (int next : graph.get(curr)) {
      if (next == prev) {
        continue;
      }

      tree.get(curr).add(next);
      dagDfs(next, curr);
    }
  }
}