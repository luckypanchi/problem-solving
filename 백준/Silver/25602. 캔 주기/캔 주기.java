import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k, answer;
  static int[] canCount;
  static int[][] catPreference1;
  static int[][] catPreference2;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MIN_VALUE;
    solve(0, 0);

    sb.append(answer);

    output();
  }

  private static void solve(int curr, int prev) {
    if (curr == k) {
      answer = Math.max(answer, prev);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (canCount[i] == 0) {
        continue;
      }
      canCount[i]--;
      for (int j = 0; j < n; j++) {
        if (canCount[j] == 0) {
          continue;
        }
        canCount[j]--;
        solve(curr + 1, prev + catPreference1[curr][i] + catPreference2[curr][j]);
        canCount[j]++;
      }
      canCount[i]++;
    }
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    canCount = new int[n];
    catPreference1 = new int[k][n];
    catPreference2 = new int[k][n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      canCount[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        catPreference1[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        catPreference2[i][j] = Integer.parseInt(st.nextToken());
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