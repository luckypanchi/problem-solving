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
  static String start;
  static int k;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    boolean[][] visited = new boolean[1000001][k + 1];
    Deque<Pair> que = new ArrayDeque<>();

    visited[Integer.parseInt(start)][k] = true;
    que.offer(new Pair(start, k));

    int length = start.length();
    int answer = -1;

    while (!que.isEmpty()) {
      Pair curr = que.pollFirst();

      if (curr.count == 0) {
        answer = Math.max(answer, Integer.parseInt(curr.number));
        continue;
      }

      for (int i = 0; i < length - 1; i++) {
        for (int j = i + 1; j < length; j++) {
          String nextNumber = swap(curr.number, i, j);
          if (nextNumber.charAt(0) != '0' && !visited[Integer.parseInt(nextNumber)][curr.count - 1]) {
            visited[Integer.parseInt(nextNumber)][curr.count - 1] = true;
            que.offer(new Pair(nextNumber, curr.count - 1));
          }
        }
      }
    }

    return answer;
  }

  private static String swap(String targetNumber, int index1, int index2) {
    char[] array = targetNumber.toCharArray();
    char tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
    return new String(array);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = st.nextToken();
    k = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    String number;
    int count;

    public Pair(String number, int count) {
      this.number = number;
      this.count = count;
    }
  }

}