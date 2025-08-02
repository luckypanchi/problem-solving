import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] heights;
  static int[] counts;
  static int[] answers;

  public static void main(String[] args) throws IOException {
    setUp();

    fromLeft();
    fromRight();

    for (int i = 1; i < n + 1; i++) {
      sb.append(counts[i]);
      if (counts[i] != 0) {
        sb.append(" ").append(answers[i]);
      }
      sb.append("\n");
    }

    output();
  }

  private static void fromRight() {
    Stack<Integer> stack = new Stack<>();
    stack.add(n);

    for (int i = n - 1; i > 0; i--) {
      while (!stack.isEmpty()) {
        int prevNumber = stack.pop();
        if (heights[i] < heights[prevNumber]) {
          stack.add(prevNumber);
          if (Math.abs(prevNumber - i) < Math.abs(answers[i] - i)) {
            answers[i] = prevNumber;
          }
          counts[i] += stack.size();
          break;
        }
      }
      stack.add(i);
    }
  }

  private static void fromLeft() {
    Stack<Integer> stack = new Stack<>();
    stack.add(1);

    for (int i = 2; i < n + 1; i++) {
      while (!stack.isEmpty()) {
        int prevNumber = stack.pop();
        if (heights[i] < heights[prevNumber]) {
          stack.add(prevNumber);
          if (Math.abs(prevNumber - i) < Math.abs(answers[i] - i)) {
            answers[i] = prevNumber;
          }
          counts[i] += stack.size();
          break;
        }
      }
      stack.add(i);
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    heights = new int[n + 1];
    counts = new int[n + 1];
    answers = new int[n + 1];
    Arrays.fill(answers, Integer.MAX_VALUE);
    for (int i = 1; i < n + 1; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}