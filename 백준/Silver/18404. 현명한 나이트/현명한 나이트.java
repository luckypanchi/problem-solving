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
  static int[] answer;
  static int startY, startX;

  static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] visited = new int[n + 1][n + 1];
    visited[startY][startX] = 1;

    Deque<Node> que = new ArrayDeque<>();
    que.add(new Node(startY, startX));

    while (!que.isEmpty()) {
      Node cur = que.poll();

      if (board[cur.y][cur.x] != 0) {
        int index = board[cur.y][cur.x] - 1;
        answer[index] = visited[cur.y][cur.x] - 1;
      }

      for (int i = 0; i < 8; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (!checkRange(ny, nx) || visited[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = visited[cur.y][cur.x] + 1;
        que.add(new Node(ny, nx));
      }
    }

    for (int i = 0; i < m; i++) {
      sb.append(answer[i]).append(" ");
    }

    output();
  }

  private static boolean checkRange(int y, int x) {
    return 0 < y && y < n + 1 && 0 < x && x < n + 1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n + 1][n + 1];
    answer = new int[m];
    st = new StringTokenizer(br.readLine());
    startY = Integer.parseInt(st.nextToken());
    startX = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      board[y][x] = i + 1;
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

}