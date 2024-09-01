import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int testcases;
  static int k, n;
  static int[][] weights;
  static int[] weights1, weights2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      weights = new int[4][n];
      for (int i = 0; i < 4; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          weights[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      weights1 = new int[n * n];
      weights2 = new int[n * n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          weights1[n * i + j] = weights[0][i] + weights[1][j];
          weights2[n * i + j] = weights[2][i] + weights[3][j];
        }
      }

      Arrays.sort(weights1);
      Arrays.sort(weights2);

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int left = 0;
    int right = n * n - 1;

    int diff = Integer.MAX_VALUE;
    int answer = -1;
    while (left < weights1.length && 0 <= right) {
      int sum = weights1[left] + weights2[right];
      if (sum == k) {
        answer = sum;
        break;
      } else if (sum < k) {
        left++;
      } else {
        right--;
      }

      if (Math.abs(k - sum) < diff) {
        diff = Math.abs(k - sum);
        answer = sum;
      } else if (Math.abs(k - sum) == diff && sum < answer) {
        answer = sum;
      }

    }

    return answer;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}