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
  static int answer;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    answer = -1;

    dfs(0, 0);

    sb.append(answer);

    output();
  }

  private static void dfs(int curr, int start) {
    if (curr == 3) {
      answer = Math.max(answer, count());
      return;
    }

    for (int next = start; next < n * m; next++) {
      int y = next / m;
      int x = next % m;
      if (board[y][x] == 0) {
        board[y][x] = 1;
        dfs(curr + 1, next + 1);
        board[y][x] = 0;
      }
    }
  }

  private static int count() {
    boolean[][] visited = new boolean[n][m];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (!visited[y][x] && board[y][x] == 2) {
          mark(y, x, visited);
        }
      }
    }

    int count = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (!visited[y][x] && board[y][x] == 0) {
          count++;
        }
      }
    }

    return count;
  }

  private static void mark(int y, int x, boolean[][] visited) {
    visited[y][x] = true;

    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{y, x});

    while (!que.isEmpty()) {
      int[] curr = que.pollFirst();

      int currY = curr[0];
      int currX = curr[1];

      for (int i = 0; i < 4; i++) {
        int ny = currY + dy[i];
        int nx = currX + dx[i];

        if (!checkRange(ny, nx) || visited[ny][nx] || board[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = true;
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