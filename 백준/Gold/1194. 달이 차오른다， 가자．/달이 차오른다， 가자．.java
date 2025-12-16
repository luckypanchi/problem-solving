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
  static int[][][] visited;
  static int startY, startX;

  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve());

    output();
  }

  private static int solve() {
    Deque<Pair> que = new ArrayDeque<>();
    que.offerLast(new Pair(startY, startX, 0));

    visited[startY][startX][0] = 1;

    while (!que.isEmpty()) {
      Pair curr = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || visited[ny][nx][curr.keyFlag] != 0 || board[ny][nx] == '#') {
          continue;
        }

        if (board[ny][nx] == '1') {
          return visited[curr.y][curr.x][curr.keyFlag];
        }

        if ('A' <= board[ny][nx] && board[ny][nx] <= 'F' && (curr.keyFlag & (1 << (board[ny][nx] - 'A'))) != 0) {
          visited[ny][nx][curr.keyFlag] = visited[curr.y][curr.x][curr.keyFlag] + 1;
          que.offerLast(new Pair(ny, nx, curr.keyFlag));
        } else if ('a' <= board[ny][nx] && board[ny][nx] <= 'f') {
          int newKeyFlag = curr.keyFlag | (1 << (board[ny][nx] - 'a'));
          visited[ny][nx][newKeyFlag] = visited[curr.y][curr.x][curr.keyFlag] + 1;
          que.offerLast(new Pair(ny, nx, newKeyFlag));
        } else if (board[ny][nx] == '.') {
          visited[ny][nx][curr.keyFlag] = visited[curr.y][curr.x][curr.keyFlag] + 1;
          que.offerLast(new Pair(ny, nx, curr.keyFlag));
        }
      }
    }

    return -1;
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
    visited = new int[n][m][1 << 6];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = row.charAt(j);
        if (board[i][j] == '0') {
          startY = i;
          startX = j;
          board[i][j] = '.';
        }
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

    int y, x, keyFlag;

    public Pair(int y, int x, int keyFlag) {
      this.y = y;
      this.x = x;
      this.keyFlag = keyFlag;
    }
  }

}