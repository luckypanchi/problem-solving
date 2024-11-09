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
  static int n, m, startY, startX, destY, destX;
  static int[][] board;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    int[][][] visited = new int[2][n + 1][m + 1];
    Deque<Pair> que = new ArrayDeque<>();

    visited[0][startY][startX] = 1;
    que.offer(new Pair(0, startY, startX));

    while (!que.isEmpty()) {
      Pair curr = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx)) {
          continue;
        }

        if (board[ny][nx] == 0 && visited[curr.count][ny][nx] == 0) {
          visited[curr.count][ny][nx] = visited[curr.count][curr.y][curr.x] + 1;
          que.offer(new Pair(curr.count, ny, nx));
        } else if (curr.count == 0 && board[ny][nx] == 1 && visited[curr.count + 1][ny][nx] == 0) {
          visited[curr.count + 1][ny][nx] = visited[curr.count][curr.y][curr.x] + 1;
          que.offer(new Pair(curr.count + 1, ny, nx));
        }
      }
    }

    return Math.min(visited[0][destY][destX], visited[1][destY][destX]) - 1;
  }

  private static boolean checkRange(int y, int x) {
    return 1 <= y && y < n + 1 && 1 <= x && x < m + 1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    startY = Integer.parseInt(st.nextToken());
    startX = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    destY = Integer.parseInt(st.nextToken());
    destX = Integer.parseInt(st.nextToken());
    board = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < m + 1; j++) {
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

  private static class Pair {

    int count, y, x;

    public Pair(int count, int y, int x) {
      this.count = count;
      this.y = y;
      this.x = x;
    }
  }

}