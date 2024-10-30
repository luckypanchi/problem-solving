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
  static int n, m;
  static int[][] board;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    int[][] visited = new int[n][m];
    Deque<Node> que = new ArrayDeque<>();

    visited[0][0] = 1;
    que.offer(new Node(0, 0));

    while (!que.isEmpty()) {
      Node curr = que.poll();

      if (curr.y == n - 1 && curr.x == m - 1) {
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (checkRange(ny, nx) && visited[ny][nx] == 0 && board[ny][nx] == 1) {
          visited[ny][nx] = visited[curr.y][curr.x] + 1;
          que.offer(new Node(ny, nx));
        }
      }
    }

    return visited[n - 1][m - 1];
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = row.charAt(j) - '0';
      }
    }
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