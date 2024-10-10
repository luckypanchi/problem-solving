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
  static int r, c, totalWolfCount, totalSheepCount;
  static char[][] board;
  static boolean[][] visited;
  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    totalWolfCount = 0;
    totalSheepCount = 0;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (!visited[i][j] && board[i][j] != '#') {
          bfs(i, j);
        }
      }
    }

    sb.append(totalSheepCount).append(" ").append(totalWolfCount);

    output();
  }

  private static void bfs(int startY, int startX) {
    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{startY, startX});
    visited[startY][startX] = true;

    int wolfCount = 0;
    int sheepCount = 0;

    while (!que.isEmpty()) {
      int[] curr = que.pollFirst();
      int currY = curr[0];
      int currX = curr[1];

      if (board[currY][currX] == 'v') {
        wolfCount++;
      } else if (board[currY][currX] == 'k') {
        sheepCount++;
      }

      for (int i = 0; i < 4; i++) {
        int ny = currY + dy[i];
        int nx = currX + dx[i];
        if (0 <= nx && nx < c && 0 <= ny && ny < r && board[ny][nx] != '#' && !visited[ny][nx]) {
          visited[ny][nx] = true;
          que.offer(new int[]{ny, nx});
        }
      }
    }

    if (wolfCount < sheepCount) {
      totalSheepCount += sheepCount;
    } else {
      totalWolfCount += wolfCount;
    }

  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    board = new char[r][c];
    visited = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
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

}