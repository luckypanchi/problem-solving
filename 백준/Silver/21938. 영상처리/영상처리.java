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
  static int n, m, t;
  static int[][] board;
  static boolean[][] visited;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (t <= board[i][j] / 3) {
          board[i][j] = 255;
        } else {
          board[i][j] = 0;
        }
      }
    }

    int answer = 0;
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 255 && !visited[i][j]) {
          mark(i, j);
          answer++;
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void mark(int startY, int startX) {
    visited[startY][startX] = true;

    Deque<Node> que = new ArrayDeque<>();
    que.add(new Node(startY, startX));

    while (!que.isEmpty()) {
      Node cur = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if (!checkRange(ny, nx) || board[ny][nx] == 0 || visited[ny][nx]) {
          continue;
        }

        visited[ny][nx] = true;
        que.add(new Node(ny, nx));
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
        int total = 0;
        for (int k = 0; k < 3; k++) {
          total += Integer.parseInt(st.nextToken());
        }
        board[i][j] = total;
      }
    }
    t = Integer.parseInt(br.readLine());
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

}