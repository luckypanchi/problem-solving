import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String target;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, target.length() - 1));

    output();
  }

  private static int solve(int start, int end) {
    if (end < start) {
      return 0;
    }

    int result = 0;

    int curr = start;
    while (curr < end + 1) {
      if (curr < end && isNumber(curr) && isOpened(curr + 1)) {
        int nextEnd = findEnd(curr + 1);
        result += stoi(curr) * solve(curr + 2, nextEnd - 1);
        curr = nextEnd + 1;
      } else {
        result++;
        curr++;
      }
    }

    return result;
  }

  private static int findEnd(int start) {
    Deque<String> stack = new ArrayDeque<>();
    for (int i = start; i < target.length(); i++) {
      if (isOpened(i)) {
        stack.push("(");
      }
      if (isClosed(i)) {
        stack.pop();
        if (stack.isEmpty()) {
          return i;
        }
      }
    }
    return -1;
  }

  private static int stoi(int index) {
    return target.charAt(index) - '0';
  }

  private static boolean isNumber(int index) {
    return !isOpened(index) && !isClosed(index);
  }

  private static boolean isOpened(int index) {
    return target.charAt(index) == '(';
  }

  private static boolean isClosed(int index) {
    return target.charAt(index) == ')';
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    target = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}