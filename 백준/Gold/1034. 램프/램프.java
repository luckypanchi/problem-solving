import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[][] lamps;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      int zeroCount = countZero(i);

      int sameRowCount = countSameRow(i);

      if (zeroCount <= k && zeroCount % 2 == k % 2) {
        answer = Math.max(answer, sameRowCount);
      }

    }

    sb.append(answer);
    output();
  }

  private static int countSameRow(int target) {
    int count = 1;
    for (int i = 0; i < n; i++) {
      if (target == i) {
        continue;
      }

      if (isSame(target, i)) {
        visited[i] = true;
        count++;
      }
    }
    return count;
  }

  private static boolean isSame(int row1, int row2) {
    for (int i = 0; i < m; i++) {
      if (lamps[row1][i] != lamps[row2][i]) {
        return false;
      }
    }
    return true;
  }

  private static int countZero(int rowNumber) {
    int zeroCount = 0;
    for (int i = 0; i < m; i++) {
      if (lamps[rowNumber][i] == 0) {
        zeroCount++;
      }
    }
    return zeroCount;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    lamps = new int[n][m];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        lamps[i][j] = row.charAt(j) - '0';
      }
    }
    k = Integer.parseInt(br.readLine());
    visited = new boolean[n];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}