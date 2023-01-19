import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {

  static int n;
  static int[][] matrix;
  static int[][] island;
  static int[][] visited;
  static boolean[][] checked;
  static int num = 0;
  static int answer = Integer.MAX_VALUE;

  static int[] dy = { 0, -1, 0, 1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    matrix = new int[n][n];
    island = new int[n][n];
    checked = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1 && island[i][j] == 0) {
          num++;
          mark(i, j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (island[i][j] != 0) {
          for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (
              0 <= ny &&
              ny < n &&
              0 <= nx &&
              nx < n &&
              island[ny][nx] == 0 &&
              checked[ny][nx] == false
            ) {
              checked[ny][nx] = true;
              go(ny, nx, island[i][j]);
            }
          }
        }
      }
    }
    System.out.println(answer);
  }

  static void mark(int y, int x) {
    Queue<Node> que = new LinkedList<>();
    island[y][x] = num;
    que.add(new Node(y, x));

    while (!que.isEmpty()) {
      Node node = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];

        if (
          0 <= ny &&
          ny < n &&
          0 <= nx &&
          nx < n &&
          matrix[ny][nx] == 1 &&
          island[ny][nx] == 0
        ) {
          island[ny][nx] = num;
          que.add(new Node(ny, nx));
        }
      }
    }
  }

  static void go(int y, int x, int islandNumber) {
    Queue<Node> que = new LinkedList<>();
    visited = new int[n][n];
    visited[y][x] = 1;
    que.add(new Node(y, x));

    while (!que.isEmpty()) {
      Node node = que.poll();

      if (island[node.y][node.x] != 0) {
        answer = Math.min(answer, visited[node.y][node.x] - 1);
        return;
      }

      if (answer <= island[node.y][node.x]) {
        return;
      }

      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];

        if (
          0 <= ny &&
          ny < n &&
          0 <= nx &&
          nx < n &&
          visited[ny][nx] == 0 &&
          island[ny][nx] != islandNumber
        ) {
          visited[ny][nx] = visited[node.y][node.x] + 1;
          que.add(new Node(ny, nx));
        }
      }
    }
  }
}
