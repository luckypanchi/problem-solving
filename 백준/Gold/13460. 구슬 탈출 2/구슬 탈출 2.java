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
  static char[][] board;
  static Node redStart, blueStart, dest;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    redStart = new Node(-1, -1);
    blueStart = new Node(-1, -1);
    dest = new Node(-1, -1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'R') {
          redStart = new Node(i, j);
          board[i][j] = '.';
        } else if (board[i][j] == 'B') {
          blueStart = new Node(i, j);
          board[i][j] = '.';
        } else if (board[i][j] == 'O') {
          dest = new Node(i, j);
        }
      }
    }

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    int[][][][] visited = new int[n][m][n][m];
    visited[redStart.y][redStart.x][blueStart.y][blueStart.x] = 1;

    Deque<Node[]> que = new ArrayDeque();
    que.offer(new Node[]{redStart, blueStart});

    while (!que.isEmpty()) {
      Node[] curr = que.pollFirst();

      Node currRed = curr[0];
      Node currBlue = curr[1];

      if (10 < visited[currRed.y][currRed.x][currBlue.y][currBlue.x]) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        Result resultRed = move(currRed, i);
        Result resultBlue = move(currBlue, i);

        int redY = resultRed.y;
        int redX = resultRed.x;
        int blueY = resultBlue.y;
        int blueX = resultBlue.x;

        if (blueY == dest.y && blueX == dest.x) {
          continue;
        }

        if (redY == blueY && redX == blueX) {
          if (resultRed.dist < resultBlue.dist) {
            blueY -= dy[i];
            blueX -= dx[i];
          } else if (resultBlue.dist < resultRed.dist) {
            redY -= dy[i];
            redX -= dx[i];
          }
        }

        if (visited[redY][redX][blueY][blueX] != 0) {
          continue;
        }

        visited[redY][redX][blueY][blueX] = visited[currRed.y][currRed.x][currBlue.y][currBlue.x] + 1;

        if (redY == dest.y && redX == dest.x) {
          return visited[redY][redX][blueY][blueX] - 1;
        }

        que.offer(new Node[]{new Node(redY, redX), new Node(blueY, blueX)});
      }
    }

    return -1;
  }

  private static Result move(Node start, int d) {
    int ny = start.y;
    int nx = start.x;
    int dist = 0;

    while (true) {
      ny += dy[d];
      nx += dx[d];

      if (!checkRange(ny, nx) || board[ny][nx] == '#') {
        ny -= dy[d];
        nx -= dx[d];
        return new Result(ny, nx, dist);
      }

      dist++;

      if (board[ny][nx] == 'O') {
        return new Result(ny, nx, dist);
      }
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
    board = new char[n][m];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = row.charAt(j);
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

  private static class Result {

    int y, x, dist;

    public Result(int y, int x, int dist) {
      this.y = y;
      this.x = x;
      this.dist = dist;
    }
  }

}