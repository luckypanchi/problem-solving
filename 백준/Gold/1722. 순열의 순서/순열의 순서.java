import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, problem;
  static long k;
  static int[] numbers;
  static long[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    if (problem == 1) {
      sb.append(solve1());
    } else {
      sb.append(solve2());
    }

    output();
  }

  private static String solve1() {
    StringBuilder answer = new StringBuilder();
    boolean[] isVisited = new boolean[n + 1];

    for (int curr = 1; curr < n + 1; curr++) {
      int count = 1;
      for (int num = 1; num < n + 1; num++) {
        if (isVisited[num]) {
          continue;
        }

        if (k <= count * factorial(n - curr)) {
          k -= (count - 1) * factorial(n - curr);
          isVisited[num] = true;
          sb.append(num).append(" ");
          break;
        }
        count++;
      }
    }

    return answer.toString();
  }

  private static long solve2() {
    boolean[] isVisited = new boolean[n + 1];
    long answer = 1;

    for (int i = 1; i < n + 1; i++) {
      int target = numbers[i - 1];

      int num = 1;
      while (num < target) {
        if (!isVisited[num]) {
          answer += factorial(n - i);
        }
        num++;
      }

      isVisited[target] = true;
    }

    return answer;
  }

  private static long factorial(int num) {
    if (dp[num] != -1) {
      return dp[num];
    }
    if (num == 0) {
      return 1;
    }
    if (num == 1) {
      return 1;
    }

    dp[num] = num * factorial(num - 1);

    return dp[num];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    problem = Integer.parseInt(st.nextToken());
    if (problem == 1) {
      k = Long.parseLong(st.nextToken());
    } else {
      numbers = new int[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new long[n + 1];
    Arrays.fill(dp, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}