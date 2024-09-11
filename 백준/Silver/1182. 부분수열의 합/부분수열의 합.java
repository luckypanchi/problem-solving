import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, s, answer;
  static int[] givens;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = 0;
    solve(0, 0);

    if (s == 0) {
      answer--;
    }

    sb.append(answer);
    output();
  }

  private static void solve(int curr, int prevSum) {
    if (curr == n) {
      if (prevSum == s) {
        answer++;
      }
      return;
    }

    solve(curr + 1, prevSum);
    solve(curr + 1, prevSum + givens[curr]);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
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