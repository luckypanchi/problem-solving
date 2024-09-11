import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] selected;
  static int[] givens;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(givens);
    solve(0, 0);

    output();
  }

  private static void solve(int curr, int start) {
    if (curr == m) {
      for (int num : selected) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < n; i++) {
      selected[curr] = givens[i];
      solve(curr + 1, i);
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    selected = new int[m];
    givens = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      givens[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}