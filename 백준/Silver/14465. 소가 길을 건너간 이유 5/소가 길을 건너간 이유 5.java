import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k, b;
  static boolean[] isBroken;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 1;
    int right = 1;
    int answer = Integer.MAX_VALUE;
    int count = isBroken[1] ? 1 : 0;
    while (right < n + 1) {
      int currLength = right - left + 1;
      if (currLength == k) {
        answer = Math.min(answer, count);
        right++;
        count = isBroken[right] ? count + 1 : count;
      } else if (currLength <= k) {
        right++;
        count = isBroken[right] ? count + 1 : count;
      } else {
        count = isBroken[left] ? count - 1 : count;
        left++;
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
    b = Integer.parseInt(st.nextToken());
    isBroken = new boolean[n + 2];
    for (int i = 0; i < b; i++) {
      isBroken[Integer.parseInt(br.readLine())] = true;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}