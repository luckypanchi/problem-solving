import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcase = 1;
    while (true) {
      String string = br.readLine();
      if (string.charAt(0) == '-') {
        break;
      }

      int answer = solve(string);
      sb.append(testcase).append(". ").append(answer).append("\n");
      testcase++;
    }

    output();
  }

  private static int solve(String string) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == '{') {
        stack.push('{');
      } else if (!stack.isEmpty() && stack.peek() == '{') {
        stack.pop();
      } else {
        stack.push('}');
      }
    }

    if (stack.isEmpty()) {
      return 0;
    }

    int answer = 0;
    while (!stack.isEmpty()) {
      char c1 = stack.pop();
      char c2 = stack.pop();

      if (c2 == '{' && c1 == '{') {
        answer++;
      } else if (c2 == '}' && c1 == '}') {
        answer++;
      } else {
        answer += 2;
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