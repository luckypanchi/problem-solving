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
  static String[] bridges;

  public static void main(String[] args) throws IOException {
    setUp();

    boolean[][] visited = new boolean[2][n];
    visited[0][0] = true;

    Deque<Node> que = new ArrayDeque<>();
    que.offer(new Node(0, 0, 0));

    int answer = 0;

    while (!que.isEmpty()) {
      Node cur = que.poll();

      if (n <= cur.pos + 1 || n <= cur.pos + k) {
        answer = 1;
        break;
      }

      if (!visited[cur.isLeft][cur.pos + 1] && bridges[cur.isLeft].charAt(cur.pos + 1) == '1') {
        visited[cur.isLeft][cur.pos + 1] = true;
        que.offer(new Node(cur.pos + 1, cur.isLeft, cur.currTime + 1));
      }

      if (0 <= cur.pos - 1 && cur.currTime < cur.pos - 1 && !visited[cur.isLeft][cur.pos - 1] && bridges[cur.isLeft].charAt(cur.pos - 1) == '1') {
        visited[cur.isLeft][cur.pos - 1] = true;
        que.offer(new Node(cur.pos - 1, cur.isLeft, cur.currTime + 1));
      }

      if (!visited[1 - cur.isLeft][cur.pos + k] && bridges[1 - cur.isLeft].charAt(cur.pos + k) == '1') {
        visited[1 - cur.isLeft][cur.pos + k] = true;
        que.offer(new Node(cur.pos + k, 1 - cur.isLeft, cur.currTime + 1));
      }

    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    bridges = new String[2];
    bridges[0] = br.readLine();
    bridges[1] = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node {

    int pos;
    int isLeft;
    int currTime;

    public Node(int pos, int isLeft, int currTime) {
      this.pos = pos;
      this.isLeft = isLeft;
      this.currTime = currTime;
    }
  }

}