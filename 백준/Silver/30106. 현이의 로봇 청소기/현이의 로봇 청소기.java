import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[][] board;
  static boolean[][] visited;
  static int[] dy = new int[]{0, 1, 0, -1};
  static int[] dx = new int[]{1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          answer++;
          visited[i][j] = true;
          markBfs(i, j);
        }
      }
    }
    sb.append(answer);

    output();
  }

  private static void markBfs(int startY, int startX) {
    Queue<int[]> que = new ArrayDeque<>();
    que.add(new int[]{startY, startX});

    while (!que.isEmpty()) {
      int[] curr = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = curr[0] + dy[i];
        int nx = curr[1] + dx[i];

        if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && Math.abs(board[curr[0]][curr[1]] - board[ny][nx]) <= k) {
          visited[ny][nx] = true;
          que.add(new int[]{ny, nx});
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
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

}