import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  int x, y;
  int count;

  public Node(int x, int y, int count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}

public class Main {

  static int r, c;
  static boolean[][] visited;
  static char[][] matrix;
  static int answer = Integer.MIN_VALUE;
  static int[] dx = { 1, 0, -1, 0 };
  static int[] dy = { 0, -1, 0, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    matrix = new char[r][c];

    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
        matrix[i][j] = row.charAt(j);
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (matrix[i][j] == 'L') {
          bfs(i, j);
        }
      }
    }
    System.out.println(answer);
  }

  public static void bfs(int y, int x) {
    Queue<Node> que = new LinkedList<>();
    visited = new boolean[r][c];

    que.add(new Node(x, y, 0));
    visited[y][x] = true;

    while (!que.isEmpty()) {
      Node node = que.poll();

      answer = Math.max(answer, node.count);

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];

        if (
          0 <= nx &&
          nx < c &&
          0 <= ny &&
          ny < r &&
          matrix[ny][nx] == 'L' &&
          visited[ny][nx] == false
        ) {
          visited[ny][nx] = true;
          que.add(new Node(nx, ny, node.count + 1));
        }
      }
    }
  }
}
