import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String pipe;

  public static void main(String[] args) throws IOException {
    setUp();

    Stack<Character> stack = new Stack<>();
    int length = pipe.length();
    int answer = 0;

    for (int i = 0; i < length; i++) {
      char curr = pipe.charAt(i);
      if (curr == '(') {
        stack.push(curr);
        continue;
      }

      char prev = pipe.charAt(i - 1);
      if (prev == '(') {
        stack.pop();
        answer += stack.size();
      } else {
        stack.pop();
        answer += 1;
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    pipe = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}