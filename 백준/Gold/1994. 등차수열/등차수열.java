import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;
  static int[][] counts;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = n == 1 ? 1 : solve();

    sb.append(answer);
    output();
  }

  private static int solve() {
    int answer = 0;
    for (int curr = 0; curr < n - 1; curr++) {
      for (int next = curr + 1; next < n; next++) {
        counts[curr][next] = 2;
        int prevNumber = numbers[curr] - (numbers[next] - numbers[curr]);
        int prev = upperBound(prevNumber, curr);
        if (prev != -1 && numbers[prev] == prevNumber) {
          counts[curr][next] = Math.max(counts[curr][next], counts[prev][curr] + 1);
        }
        answer = Math.max(answer, counts[curr][next]);
      }
    }
    return answer;
  }

  public static int upperBound(int target, int right) {
    int left = 0;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (numbers[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left - 1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(numbers);
    counts = new int[n][n];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}