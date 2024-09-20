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
  static char[] givens;
  static char[] selected;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(givens);
    combinations(0, 0, 0, 0);

    output();
  }

  private static void combinations(int curr, int start, int consonantCount, int vowelCount) {
    if (curr == n) {
      if (1 <= vowelCount && 2 <= consonantCount) {
        for (char c : selected) {
          sb.append(c);
        }
        sb.append("\n");
      }
      return;
    }

    for (int i = start; i < m; i++) {
      selected[curr] = givens[i];
      if (givens[i] == 'a' || givens[i] == 'e' || givens[i] == 'i' || givens[i] == 'o' || givens[i] == 'u') {
        combinations(curr + 1, i + 1, consonantCount, vowelCount + 1);
      } else {
        combinations(curr + 1, i + 1, consonantCount + 1, vowelCount);
      }
    }

  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    selected = new char[n];
    givens = new char[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      givens[i] = st.nextToken().charAt(0);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}