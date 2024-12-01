import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] minDp = new String[101];
    minDp[0] = "0";
    minDp[1] = "0";
    minDp[2] = "1";
    minDp[3] = "7";
    minDp[4] = "4";
    minDp[5] = "2";
    minDp[6] = "6";
    minDp[7] = "8";

    for (int target = 8; target < 101; target++) {
      String prev = "9".repeat(100);
      for (int left = 2; left < target - 1; left++) {
        int right = target - left != 6 ? target - left : 0;
        if (cmp(prev, minDp[left] + minDp[right])) {
          prev = minDp[left] + minDp[right];
        }
      }
      minDp[target] = prev;
    }

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(minDp[n]).append(" ").append(getMax(n)).append("\n");
    }

    output();
  }

  private static boolean cmp(String prev, String curr) {
    if (curr.length() == prev.length()) {
      for (int i = 0; i < prev.length(); i++) {
        if (prev.charAt(i) != curr.charAt(i)) {
          return (curr.charAt(i) - '0') - (prev.charAt(i) - '0') < 0;
        }
      }
    }
    return curr.length() < prev.length();
  }

  private static String getMax(int n) {
    StringBuilder result = new StringBuilder();

    while (n > 0) {
      if (n == 3) {
        result.append(7);
        n -= 3;
      } else {
        result.append(1);
        n -= 2;
      }
    }

    result.reverse();
    return result.toString();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}