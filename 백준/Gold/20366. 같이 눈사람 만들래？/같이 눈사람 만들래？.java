import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] snowballs;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(snowballs);
    int answer = Integer.MAX_VALUE;
    for (int start = 0; start < n; start++) {
      for (int end = start + 3; end < n; end++) {
        int left = start + 1;
        int right = end - 1;

        while (left < right) {
          int diff = (snowballs[start] + snowballs[end]) - (snowballs[left] + snowballs[right]);
          answer = Math.min(answer, Math.abs(diff));

          if (diff < 0) {
            right--;
          } else {
            left++;
          }
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    snowballs = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      snowballs[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}