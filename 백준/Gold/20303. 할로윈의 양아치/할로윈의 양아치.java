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
  static int n, m, k;
  static int[] candyCounts, peopleCounts;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    setUp();

    List<Group> groupList = new ArrayList<>();
    for (int i = 1; i < n + 1; i++) {
      if (find(i) == i) {
        groupList.add(new Group(peopleCounts[i], candyCounts[i]));
      }
    }

    int[][] dp = new int[groupList.size() + 1][k + 1];
    for (int i = 1; i < groupList.size() + 1; i++) {
      Group curr = groupList.get(i - 1);
      for (int w = 1; w < k; w++) {
        if (curr.peopleCount <= w) {
          dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - curr.peopleCount] + curr.candyCount);
        } else {
          dp[i][w] = dp[i - 1][w];
        }
      }
    }

    sb.append(dp[groupList.size()][k - 1]);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    candyCounts = new int[n + 1];
    peopleCounts = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      parents[i] = i;
      candyCounts[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.fill(peopleCounts, 1);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
    }
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return false;
    }

    if (x < y) {
      parents[y] = x;
      candyCounts[x] += candyCounts[y];
      peopleCounts[x] += peopleCounts[y];
      candyCounts[y] = 0;
      peopleCounts[y] = 0;
    } else {
      parents[x] = y;
      candyCounts[y] += candyCounts[x];
      peopleCounts[y] += peopleCounts[x];
      candyCounts[x] = 0;
      peopleCounts[x] = 0;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Group {

    int peopleCount, candyCount;

    public Group(int peopleCount, int candyCount) {
      this.peopleCount = peopleCount;
      this.candyCount = candyCount;
    }

  }

}