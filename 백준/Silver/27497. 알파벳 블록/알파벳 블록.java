import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static Deque<Operation> stack;
  static Deque<String> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    stack = new ArrayDeque<>();
    answer = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String op = st.nextToken();
      if (op.equals("3")) {
        if (!stack.isEmpty()) {
          stack.pollLast();
        }
      } else {
        String c = st.nextToken();
        stack.offerLast(new Operation(op, c));
      }
    }

    while (!stack.isEmpty()) {
      Operation operation = stack.pollFirst();
      if (operation.op.equals("1")) {
        answer.offerLast(operation.character);
      } else {
        answer.offerFirst(operation.character);
      }
    }

    if (!answer.isEmpty()) {
      while (!answer.isEmpty()) {
        sb.append(answer.pollFirst());
      }
    } else {
      sb.append(0);
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Operation {

    String op, character;

    public Operation(String op, String character) {
      this.op = op;
      this.character = character;
    }

  }

}