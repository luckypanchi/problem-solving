import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] s;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    int left = 0;
    int right = 0;
    int count = 0;
    while (right < n) {
      if (s[right] % 2 == 0) {
        answer = Math.max(answer, right - left + 1 - count);
        right++;
      } else if (count < k) {
        count++;
        right++;
      } else if (s[left] % 2 == 0) {
        left++;
      } else {
        left++;
        count--;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    s = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      s[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}