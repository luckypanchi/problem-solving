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
  static int n;
  static int[] towers;
  static int[] answer;

  public static void main(String[] args) throws IOException {
    setUp();

    Deque<Integer> stack = new ArrayDeque<>();

    for (int towerNumber = n; towerNumber > 0; towerNumber--) {
      if (stack.isEmpty()) {
        stack.push(towerNumber);
        continue;
      }

      if (towers[stack.peek()] < towers[towerNumber]) {
        while (!stack.isEmpty() && towers[stack.peek()] <= towers[towerNumber]) {
          answer[stack.pop()] = towerNumber;
        }
      }
      
      stack.push(towerNumber);
    }

    while (!stack.isEmpty()) {
      answer[stack.pop()] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      sb.append(answer[i]).append(" ");
    }
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    towers = new int[n + 1];
    answer = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      towers[i + 1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}