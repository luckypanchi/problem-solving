import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      numbers = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(numbers);
      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int left = 0;
    int right = n - 1;
    int minDiff = Integer.MAX_VALUE;
    int count = 0;

    while (left < right) {
      int diff = Math.abs(numbers[left] + numbers[right] - k);
      if (diff < minDiff) {
        minDiff = diff;
        count = 1;
      } else if (diff == minDiff) {
        count++;
      }

      if (k < numbers[left] + numbers[right]) {
        right--;
      } else {
        left++;
      }
    }

    return count;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}