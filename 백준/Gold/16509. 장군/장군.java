import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r1, c1, r2, c2;

  static int[][] dx = {
      {1, 1, 1},
      {0, 1, 1},
      {0, -1, -1},
      {-1, -1, -1},
      {-1, -1, -1},
      {0, -1, -1},
      {0, 1, 1},
      {1, 1, 1},
  };

  static int[][] dy = {
      {0, 1, 1},
      {1, 1, 1},
      {1, 1, 1},
      {0, 1, 1},
      {0, -1, -1},
      {-1, -1, -1},
      {-1, -1, -1},
      {0, -1, -1},
  };

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] visited = new int[10][9];
    for (int i = 0; i < 10; i++) {
      Arrays.fill(visited[i], -1);
    }
    visited[r1][c1] = 0;

    Deque<Node> que = new ArrayDeque<>();
    que.offer(new Node(r1, c1));

    while (!que.isEmpty()) {
      Node cur = que.poll();

      if (cur.y == r2 && cur.x == c2) {
        break;
      }

      for (int i = 0; i < 8; i++) {
        Node next = move(cur, i);
        if ((next.y == -1 && next.x == -1) || visited[next.y][next.x] != -1) {
          continue;
        }

        visited[next.y][next.x] = visited[cur.y][cur.x] + 1;
        que.offer(new Node(next.y, next.x));
      }
    }

    sb.append(visited[r2][c2]);

    output();
  }

  private static Node move(Node cur, int dir) {
    int y = cur.y;
    int x = cur.x;

    for (int i = 0; i < 3; i++) {
      int ny = y + dy[dir][i];
      int nx = x + dx[dir][i];

      if (!checkRange(ny, nx) || (i != 2 && ny == r2 && nx == c2)) {
        return new Node(-1, -1);
      }

      y = ny;
      x = nx;
    }

    return new Node(y, x);
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < 10 && 0 <= x && x < 9;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}