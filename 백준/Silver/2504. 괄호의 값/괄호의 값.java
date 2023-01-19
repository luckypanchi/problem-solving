import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  static int value = 1;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st = br.readLine();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < st.length(); i++) {
      char input = st.charAt(i);
      if (input == '(') {
        stack.push(input);
        value *= 2;
      } else if (input == '[') {
        stack.push(input);
        value *= 3;
      } else if (input == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          answer = 0;
          break;
        }
        if (st.charAt(i - 1) == '(') {
          answer += value;
        }
        stack.pop();
        value /= 2;
      } else if (input == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          answer = 0;
          break;
        }
        if (st.charAt(i - 1) == '[') {
          answer += value;
        }
        stack.pop();
        value /= 3;
      }
    }
    if (!stack.isEmpty()) {
      answer = 0;
    }
    System.out.println(answer);
  }
}
