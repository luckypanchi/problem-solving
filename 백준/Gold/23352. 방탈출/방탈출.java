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
  static int maxPath;
  static int maxSum;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    maxPath = 0;
    maxSum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != 0) {
          bfs(i, j);
        }
      }
    }

    sb.append(maxSum);
    output();
  }

  private static void bfs(int y, int x) {
    int[][] visited = new int[n][m];
    visited[y][x] = 1;

    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{y, x});

    while (!que.isEmpty()) {
      int[] cur = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if (!checkRange(ny, nx) || board[ny][nx] == 0 || visited[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
        que.offer(new int[]{ny, nx});

        if (maxPath < visited[ny][nx]) {
          maxPath = visited[ny][nx];
          maxSum = board[y][x] + board[ny][nx];
        } else if (maxPath == visited[ny][nx]) {
          maxSum = Math.max(maxSum, board[y][x] + board[ny][nx]);
        }
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
    board = new int[n][m];
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

}