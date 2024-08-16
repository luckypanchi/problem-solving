import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String exp;
  static double[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        stack.push(calculate(stack.pop(), stack.pop(), c));
      } else {
        stack.push(numbers[c - 'A']);
      }
    }

    sb.append(String.format("%.2f", stack.pop()));

    output();
  }

  private static double calculate(double num2, double num1, char op) {
    switch (op) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
      case '/':
        return num1 / num2;
    }

    return 0;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    numbers = new double[n];
    exp = br.readLine();
    for (int i = 0; i < n; i++) {
      numbers[i] = Double.parseDouble(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}