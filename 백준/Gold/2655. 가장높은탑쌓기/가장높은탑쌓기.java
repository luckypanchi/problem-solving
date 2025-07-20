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
  static int[][] bricks;

  static int[] dp;
  static int[] heights;
  static int[] next;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(bricks, (b1, b2) -> {
      if (b1[0] != b2[0]) {
        return b1[0] - b2[0];
      }
      return b1[2] - b2[2];
    });

    for (int start = 1; start < n + 1; start++) {
      if (heights[start] == -1) {
        solve(start);
      }
    }

    int total = 0;
    List<Integer> selected = new ArrayList<>();

    int curr = findStart();
    while (curr != -1) {
      total++;
      selected.add(bricks[curr][3]);
      curr = next[curr];
    }

    sb.append(total).append("\n");
    for (int num : selected) {
      sb.append(num).append("\n");
    }
    output();
  }


  private static int findStart() {
    int max = -1;
    int target = -1;

    for (int i = 1; i < n + 1; i++) {
      if (max < dp[i]) {
        max = dp[i];
        target = i;
      }
    }
    return target;
  }

  private static int solve(int curr) {
    if (curr == n + 1) {
      return 0;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }

    int currArea = bricks[curr][0];
    int currHeight = bricks[curr][1];
    int currWeight = bricks[curr][2];

    int maxHeight = currHeight;
    int nextIndex = -1;

    for (int i = curr + 1; i < n + 1; i++) {
      if (currArea <= bricks[i][0] && currWeight <= bricks[i][2]) {
        int height = currHeight + solve(i);
        if (maxHeight < height) {
          maxHeight = height;
          nextIndex = i;
        }
      }
    }

    dp[curr] = maxHeight;
    next[curr] = nextIndex;

    return maxHeight;
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    bricks = new int[n + 1][4];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      bricks[i][0] = Integer.parseInt(st.nextToken());
      bricks[i][1] = Integer.parseInt(st.nextToken());
      bricks[i][2] = Integer.parseInt(st.nextToken());
      bricks[i][3] = i;
    }

    dp = new int[n + 1];
    heights = new int[n + 1];
    next = new int[n + 1];

    Arrays.fill(dp, -1);
    Arrays.fill(heights, -1);
    Arrays.fill(next, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}
