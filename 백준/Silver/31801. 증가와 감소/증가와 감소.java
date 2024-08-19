import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append(prefixSum[b] - prefixSum[a - 1]).append("\n");
    }

    output();
  }

  private static void setUp() throws IOException {
    prefixSum = new int[1000001];
    for (int num = 1; num < 1000001; num++) {
      if (check(num)) {
        prefixSum[num] = prefixSum[num - 1] + 1;
      } else {
        prefixSum[num] = prefixSum[num - 1];
      }
    }
  }

  private static boolean check(int number) {
    String num = String.valueOf(number);
    if (num.length() == 1 || num.length() == 2) {
      return false;
    }

    boolean ascending = true;
    for (int i = 1; i < num.length(); i++) {
      int prev = num.charAt(i - 1) - '0';
      int curr = num.charAt(i) - '0';

      if (i == 1 && prev >= curr) {
        return false;
      }

      if (ascending && prev > curr) {
        ascending = false;
      } else if (!ascending && prev < curr) {
        return false;
      } else if (prev == curr) {
        return false;
      }
    }

    if (ascending) {
      return false;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}