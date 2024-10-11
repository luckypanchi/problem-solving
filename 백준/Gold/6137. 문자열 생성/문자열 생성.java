import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String start;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 0;
    int right = n - 1;
    int count = 0;
    while (left <= right) {
      if (start.charAt(left) == start.charAt(right)) {
        if (isLeft(left, right)) {
          sb.append(start.charAt(left));
          left++;
        } else {
          sb.append(start.charAt(right));
          right--;
        }
      } else if (start.charAt(left) < start.charAt(right)) {
        sb.append(start.charAt(left));
        left++;
      } else {
        sb.append(start.charAt(right));
        right--;
      }

      count++;
      if (count == 80) {
        sb.append("\n");
        count = 0;
      }
    }

    output();
  }

  private static boolean isLeft(int left, int right) {
    while (left < right) {
      if (start.charAt(left) < start.charAt(right)) {
        return true;
      } else if (start.charAt(left) > start.charAt(right)) {
        return false;
      } else {
        left++;
        right--;
      }
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringBuilder startSb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      startSb.append(br.readLine());
    }
    start = startSb.toString();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}