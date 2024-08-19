import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] array;
  static int left, right, totalSum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    array = new int[n];
    left = 0;
    right = 0;
    totalSum = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int q = Integer.parseInt(st.nextToken());
      if (q == 1) {
        int x = Integer.parseInt(st.nextToken());
        array[right] = x;
        right++;
        totalSum += x;
      } else if (q == 2) {
        solve();
      }
    }

    for (int i = left; i < right; i++) {
      sb.append(array[i]).append(" ");
    }

    output();
  }

  private static void solve() {
    int mid = left + (right - left) / 2;
    int leftSum = 0;
    for (int i = left; i < mid; i++) {
      leftSum += array[i];
    }
    int rightSum = totalSum - leftSum;

    if (leftSum <= rightSum) {
      totalSum -= leftSum;
      left = mid;
      sb.append(leftSum);
    } else {
      totalSum -= rightSum;
      right = mid;
      sb.append(rightSum);
    }

    sb.append("\n");
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}