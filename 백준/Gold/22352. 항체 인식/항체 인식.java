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
  static int[][] board1, board2, resultBoard;
  static boolean[][] visited;

  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve() ? "YES" : "NO");

    output();
  }

  private static boolean solve() {

    boolean isFirstTime = true;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board1[i][j] != board2[i][j] && !visited[i][j]) {
          if (isFirstTime) {
            bfs(i, j, board1[i][j], board2[i][j]);
            isFirstTime = false;
          } else {
            return false;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (resultBoard[i][j] != board2[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  private static void bfs(int y, int x, int number, int resultNumber) {
    visited[y][x] = true;
    resultBoard[y][x] = resultNumber;

    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{y, x});

    while (!que.isEmpty()) {
      int[] cur = que.pollFirst();
      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];
        if (!checkRange(ny, nx) || visited[ny][nx] || board1[ny][nx] != number) {
          continue;
        }

        visited[ny][nx] = true;
        resultBoard[ny][nx] = resultNumber;
        que.offer(new int[]{ny, nx});
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
    board1 = new int[n][m];
    board2 = new int[n][m];
    resultBoard = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board1[i][j] = Integer.parseInt(st.nextToken());
        resultBoard[i][j] = board1[i][j];
      }
    }
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board2[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}