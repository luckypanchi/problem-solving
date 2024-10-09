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
  static int n, k;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append('<');
    Deque<Integer> que = new ArrayDeque<>();
    for (int i = 1; i < n + 1; i++) {
      que.offer(i);
    }
    int count = 1;
    while (!que.isEmpty()) {
      int curr = que.pollFirst();
      if (count == k) {
        sb.append(curr).append(',').append(' ');
        count = 1;
      } else {
        que.offer(curr);
        count++;
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    sb.deleteCharAt(sb.length() - 1);
    sb.append('>');
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}