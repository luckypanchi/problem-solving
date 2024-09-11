import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] selected;

  public static void main(String[] args) throws IOException {
    setUp();

    solve(0);

    output();
  }

  private static void solve(int curr) {
    if (curr == m) {
      for (int num : selected) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i < n + 1; i++) {
      selected[curr] = i;
      solve(curr + 1);
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    selected = new int[m];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}