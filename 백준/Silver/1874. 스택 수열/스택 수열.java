import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] targets;

  public static void main(String[] args) throws IOException {
    setUp();

    Stack<Integer> stack = new Stack<>();
    int cursor = 0;
    for (int pushNumber = 1; pushNumber < n + 1; pushNumber++) {
      stack.push(pushNumber);
      sb.append("+").append("\n");

      while (!stack.isEmpty() && stack.peek() == targets[cursor]) {
        stack.pop();
        sb.append("-").append("\n");
        cursor++;
      }
    }

    if (!stack.isEmpty()) {
      sb = new StringBuilder();
      sb.append("NO");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    targets = new int[n];
    for (int i = 0; i < n; i++) {
      targets[i] = Integer.parseInt(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}