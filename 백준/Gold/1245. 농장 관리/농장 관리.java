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
  static int n, m, answer;
  static int[][] board;
  static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && board[i][j] != 0) {
          bfs(i, j, board[i][j]);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void bfs(int startY, int startX, int height) {
    Deque<Node> que = new ArrayDeque<>();

    que.offer(new Node(startY, startX));
    visited[startY][startX] = true;

    boolean isTop = true;

    while (!que.isEmpty()) {
      Node curr = que.pollFirst();

      for (int i = 0; i < 8; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx)) {
          continue;
        }

        if (height < board[ny][nx]) {
          isTop = false;
        } else if (board[ny][nx] == height && !visited[ny][nx]) {
          que.offer(new Node(ny, nx));
          visited[ny][nx] = true;
        }
      }
    }

    if (isTop) {
      answer++;
    }
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
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
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