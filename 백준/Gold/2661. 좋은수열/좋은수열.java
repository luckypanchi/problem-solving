import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] selected;

  public static void main(String[] args) throws IOException {
    setUp();

    dfs(0);

    for (int num : selected) {
      sb.append(num);
    }
    output();
  }

  private static boolean dfs(int curr) {
    if (curr == n) {
      return true;
    }

    for (int i = 1; i < 4; i++) {
      selected[curr] = i;
      if (check(curr) && dfs(curr + 1)) {
        return true;
      }
    }

    return false;
  }

  private static boolean check(int curr) {
    for (int length = 1; length < (curr + 1) / 2 + 1; length++) {
      int start1 = curr - 2 * length + 1;
      int start2 = curr - length + 1;
      if (!checkRange(start1, start2, length)) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkRange(int start1, int start2, int length) {
    for (int i = 0; i < length; i++) {
      if (selected[start1 + i] != selected[start2 + i]) {
        return true;
      }
    }
    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    selected = new int[n];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}