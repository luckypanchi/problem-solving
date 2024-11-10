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
  static int n, m, h, w, startY, startX, destY, destX;
  static int[][] board;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());
    output();
  }

  private static int bfs() {
    int[][] visited = new int[n + 1][m + 1];
    Deque<Pair> que = new ArrayDeque<>();

    visited[startY][startX] = 1;
    que.offer(new Pair(startY, startX));

    while (!que.isEmpty()) {
      Pair curr = que.pollFirst();

      if (curr.y == destY && curr.x == destX) {
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || !checkWall(ny, nx) || visited[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = visited[curr.y][curr.x] + 1;
        que.offer(new Pair(ny, nx));
      }
    }

    return visited[destY][destX] - 1;
  }

  private static boolean checkRange(int y, int x) {
    return 1 <= y && y + h - 1 < n + 1 && 1 <= x && x + w - 1 < m + 1;
  }

  private static boolean checkWall(int y, int x) {
    for (int i = x; i < x + w; i++) {
      if (board[y][i] == 1 || board[y + h - 1][i] == 1) {
        return false;
      }
    }

    for (int i = y + 1; i < y + h - 1; i++) {
      if (board[i][x] == 1 || board[i][x + w - 1] == 1) {
        return false;
      }
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < m + 1; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    startY = Integer.parseInt(st.nextToken());
    startX = Integer.parseInt(st.nextToken());
    destY = Integer.parseInt(st.nextToken());
    destX = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int y, x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}