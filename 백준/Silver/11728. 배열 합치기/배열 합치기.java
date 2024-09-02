import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();

  static int n, m;
  static int[] a, b, answer;

  public static void main(String[] args) throws IOException {
    setUp();

    int i = 0;
    int left = 0;
    int right = 0;
    while (left < n && right < m) {
      if (a[left] < b[right]) {
        answer[i] = a[left];
        left++;
      } else {
        answer[i] = b[right];
        right++;
      }
      i++;
    }

    while (left < n) {
      answer[i] = a[left];
      i++;
      left++;
    }

    while (right < m) {
      answer[i] = b[right];
      i++;
      right++;
    }

    for (int num : answer) {
      sb.append(num).append(" ");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    a = new int[n];
    b = new int[m];
    answer = new int[n + m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}