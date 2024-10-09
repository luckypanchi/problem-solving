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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      target = br.readLine();
      sb.append(solve()).append("\n");
    }

    output();
  }

  private static String solve() {
    Deque<Character> left = new ArrayDeque<>();
    Deque<Character> right = new ArrayDeque<>();

    for (int i = 0; i < target.length(); i++) {
      char curr = target.charAt(i);
      if (curr == '<' && !left.isEmpty()) {
        right.offer(left.pollLast());
      } else if (curr == '>' && !right.isEmpty()) {
        left.offer(right.pollLast());
      } else if (curr == '-' && !left.isEmpty()) {
        left.pollLast();
      } else if (Character.isLetterOrDigit(curr)) {
        left.offer(curr);
      }
    }

    StringBuilder result = new StringBuilder();
    while (!left.isEmpty()) {
      result.append(left.pollFirst());
    }
    while (!right.isEmpty()) {
      result.append(right.pollLast());
    }

    return result.toString();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}