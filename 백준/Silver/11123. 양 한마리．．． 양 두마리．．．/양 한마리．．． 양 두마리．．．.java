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
  static int h, w;
  static char[][] board;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      board = new char[h][w];
      for (int i = 0; i < h; i++) {
        String row = br.readLine();
        for (int j = 0; j < w; j++) {
          board[i][j] = row.charAt(j);
        }
      }

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static int solve() {
    int result = 0;
    visited = new boolean[h][w];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (board[i][j] == '#' && !visited[i][j]) {
          visited[i][j] = true;
          result++;
          bfs(i, j);
        }
      }
    }

    return result;
  }

  private static void bfs(int startY, int startX) {
    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{startY, startX});

    while (!que.isEmpty()) {
      int[] curr = que.pollFirst();
      int currY = curr[0];
      int currX = curr[1];

      for (int i = 0; i < 4; i++) {
        int ny = currY + dy[i];
        int nx = currX + dx[i];

        if (check(ny, nx) && board[ny][nx] == '#' && !visited[ny][nx]) {
          visited[ny][nx] = true;
          que.offer(new int[]{ny, nx});
        }
      }
    }

  }

  private static boolean check(int y, int x) {
    return 0 <= y && y < h && 0 <= x && x < w;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}