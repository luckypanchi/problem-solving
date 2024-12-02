import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static List<Integer>[] graph;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0));

    output();
  }

  private static int solve(int curr) {
    for (int next : graph[curr]) {
      dp[next] = solve(next);
    }

    graph[curr].sort((o1, o2) -> dp[o2] - dp[o1]);
    int result = 0;
    for (int i = 0; i < graph[curr].size(); i++) {
      int next = graph[curr].get(i);
      dp[next] += i + 1;
      result = Math.max(result, dp[next]);
    }
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    graph = new List[n];
    dp = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
      int parent = Integer.parseInt(st.nextToken());
      if (parent != -1) {
        graph[parent].add(i);
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