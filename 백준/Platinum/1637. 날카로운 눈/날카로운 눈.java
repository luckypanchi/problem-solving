import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    long left = 1;
    long right = Integer.MAX_VALUE;
    long answer = -1;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (count(mid) % 2 == 0) {
        left = mid + 1;
      } else {
        answer = mid;
        right = mid - 1;
      }
    }

    if (answer == -1) {
      sb.append("NOTHING");
    } else {
      sb.append(answer).append(" ").append(count(answer) - count(answer - 1));
    }

    output();
  }

  private static long count(long curr) {
    long result = 0;
    for (int[] q : numbers) {
      int a = q[0];
      int c = q[1];
      int b = q[2];

      long limit = Math.min(curr, c);
      if (a <= limit) {
        result += (limit - a) / b + 1;
      }
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      numbers[i][0] = Integer.parseInt(st.nextToken());
      numbers[i][1] = Integer.parseInt(st.nextToken());
      numbers[i][2] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}