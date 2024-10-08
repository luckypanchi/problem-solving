import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[] moneyAmounts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      moneyAmounts = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        moneyAmounts[i] = Integer.parseInt(st.nextToken());
      }

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int answer = 0;

    int currAmount = 0;
    for (int i = 0; i < m; i++) {
      currAmount += moneyAmounts[i];
    }

    if (currAmount < k) {
      answer++;
    }

    if (n == m) {
      return answer;
    }

    for (int start = 0; start < n - 1; start++) {
      currAmount -= moneyAmounts[start];
      currAmount += moneyAmounts[(start + m) % n];

      if (currAmount < k) {
        answer++;
      }
    }

    return answer;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}