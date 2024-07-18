import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static StringBuilder sb = new StringBuilder();
  static int n;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      Stack<Character> stack = new Stack<>();
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        char curr = input.charAt(j);
        if (stack.size() != 0 && stack.peek() == curr) {
          stack.pop();
        } else {
          stack.push(curr);
        }
      }

      if (stack.isEmpty()) {
        answer++;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    n = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}