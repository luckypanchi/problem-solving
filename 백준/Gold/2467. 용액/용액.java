import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long[] liquids;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 0;
    int right = n - 1;

    long diff = Long.MAX_VALUE;
    long[] answer = new long[2];
    while (left < right) {
      long sum = liquids[left] + liquids[right];
      if (Math.abs(sum) < diff) {
        answer[0] = liquids[left];
        answer[1] = liquids[right];
        diff = Math.abs(sum);
      }

      if (sum == 0) {
        break;
      } else if (sum < 0) {
        left++;
      } else {
        right--;
      }

    }

    sb.append(answer[0]).append(" ").append(answer[1]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    liquids = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      liquids[i] = Long.parseLong(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}