import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Map<Integer, List<int[]>> white, black;
  static boolean[] daegakCheck;

  public static void main(String[] args) throws IOException {
    setUp();

    int whiteCount = solve(white, 0, 0);
    int blackCount = solve(black, 0, 0);

    sb.append(whiteCount + blackCount);

    output();
  }

  private static int solve(Map<Integer, List<int[]>> nodes, int curr, int prevCount) {
    if (curr == 2 * n - 1) {
      return prevCount;
    }

    int result = solve(nodes, curr + 1, prevCount);

    for (int[] node : nodes.get(curr)) {
      int y = node[0];
      int x = node[1];

      if (!daegakCheck[n - 1 + x - y]) {
        daegakCheck[n - 1 + x - y] = true;
        result = Math.max(result, solve(nodes, curr + 1, prevCount + 1));
        daegakCheck[n - 1 + x - y] = false;
      }
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    white = new HashMap<>();
    black = new HashMap<>();
    daegakCheck = new boolean[2 * n - 1];
    for (int i = 0; i < 2 * n - 1; i++) {
      white.put(i, new ArrayList<>());
      black.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      boolean isWhite = i % 2 == 0;
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int curr = Integer.parseInt(st.nextToken());
        if (curr == 1) {
          if (isWhite) {
            white.get(i + j).add(new int[]{i, j});
          } else {
            black.get(i + j).add(new int[]{i, j});
          }
        }
        isWhite = !isWhite;
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