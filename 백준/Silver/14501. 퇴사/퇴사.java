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
  static int n;
  static List<Node> list;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dfs(0));

    output();
  }

  private static int dfs(int curr) {
    if (curr == n) {
      return 0;
    }
    if (curr > n) {
      return Integer.MIN_VALUE;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    Node currNode = list.get(curr);
    int result = Math.max(currNode.pay + dfs(curr + currNode.time), dfs(curr + 1));

    dp[curr] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      int pay = Integer.parseInt(st.nextToken());
      list.add(new Node(time, pay));
    }
    dp = new int[n];
    Arrays.fill(dp, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node {

    int time, pay;

    public Node(int time, int pay) {
      this.time = time;
      this.pay = pay;
    }
  }

}