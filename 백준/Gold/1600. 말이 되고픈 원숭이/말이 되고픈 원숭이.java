import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  int y, x, count;

  public Node(int y, int x, int count) {
    this.y = y;
    this.x = x;
    this.count = count;
  }
}

public class Main {

  static int k, h, w;
  static int[][] matrix;
  static int[][][] visited;
  static int answer = Integer.MAX_VALUE;

  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, -1, 0, 1 };

  static int[] hx = { 2, 1, -1, -2, -2, -1, 1, 2 };
  static int[] hy = { -1, -2, -2, -1, 1, 2, 2, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    k = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    matrix = new int[h][w];
    visited = new int[h][w][k + 1];

    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    bfs();

    if (answer == Integer.MAX_VALUE) {
      System.out.println("-1");
    } else {
      System.out.println(answer);
    }
  }

  public static void bfs() {
    Queue<Node> que = new LinkedList<>();
    visited[0][0][k] = 1;
    que.add(new Node(0, 0, k));

    while (!que.isEmpty()) {
      Node node = que.poll();

      if (node.x == w - 1 && node.y == h - 1) {
        answer = Math.min(answer, visited[node.y][node.x][node.count] - 1);
        continue;
      }

      if (node.count > 0) {
        for (int i = 0; i < 8; i++) {
          int ny = node.y + hy[i];
          int nx = node.x + hx[i];

          if (
            0 <= ny &&
            ny < h &&
            0 <= nx &&
            nx < w &&
            matrix[ny][nx] == 0 &&
            visited[ny][nx][node.count - 1] == 0
          ) {
            visited[ny][nx][node.count - 1] =
              visited[node.y][node.x][node.count] + 1;
            que.add(new Node(ny, nx, node.count - 1));
          }
        }
      }

      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];

        if (
          0 <= ny &&
          ny < h &&
          0 <= nx &&
          nx < w &&
          matrix[ny][nx] == 0 &&
          visited[ny][nx][node.count] == 0
        ) {
          visited[ny][nx][node.count] = visited[node.y][node.x][node.count] + 1;
          que.add(new Node(ny, nx, node.count));
        }
      }
    }
  }
}
