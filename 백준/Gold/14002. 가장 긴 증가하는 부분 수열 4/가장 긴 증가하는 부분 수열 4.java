import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    dp = new int[n + 1];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < i; j++) {
        if (numbers[j] < numbers[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int maxLength = max(dp);
    int currLength = maxLength;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = n; i > 0; i--) {
      if (dp[i] == currLength) {
        stack.add(numbers[i]);
        currLength--;
      }
    }

    sb.append(maxLength).append("\n");
    while (!stack.isEmpty()) {
      sb.append(stack.pollLast()).append(" ");
    }

    output();
  }

  private static int max(int[] array) {
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      result = Math.max(result, array[i]);
    }
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}