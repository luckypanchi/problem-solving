import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] counts, start;
  static final int LIMIT = 1_000_000;

  public static void main(String[] args) throws IOException {
    setUp();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 1; tc < testcases + 1; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      int answer = solve();
      sb.append("Case #").append(tc).append(": ").append(answer).append("\n");
    }

    output();
  }

  private static int solve() {
    int result = 0;
    for (int target = 2; target < n; target++) {
      if (counts[target] == counts[n] && m <= start[target]) {
        result += 1;
      }
    }
    return result;
  }

  private static void setUp() {
    counts = new int[LIMIT + 1];
    start = new int[LIMIT + 1];

    for (int i = 2; i < LIMIT + 1; i++) {
      for (int target = i + i; target < LIMIT + 1; target += i) {
        counts[target] += 1;
        if (start[target] == 0) {
          start[target] = i;
        }
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