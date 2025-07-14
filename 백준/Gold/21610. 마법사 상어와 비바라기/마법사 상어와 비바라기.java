import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;

  static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

  static int[] ddx = {-1, 1, 1, -1};
  static int[] ddy = {-1, -1, 1, 1};

  static List<Node> clouds;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    clouds = new ArrayList<>();
    clouds.add(new Node(n - 1, 0));
    clouds.add(new Node(n - 1, 1));
    clouds.add(new Node(n - 2, 0));
    clouds.add(new Node(n - 2, 1));

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());

      solve(d - 1, s);
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        answer += board[i][j];
      }
    }

    sb.append(answer);
    output();
  }

  private static void solve(int direction, int speed) {
    moveClouds(direction, speed);

    rain();

    waterCopyBug();

    createClouds();
  }

  private static void createClouds() {
    List<Node> result = new ArrayList<>();

    boolean[][] visited = new boolean[n][n];
    for (Node curr : clouds) {
      visited[curr.y][curr.x] = true;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (2 <= board[i][j] && !visited[i][j]) {
          result.add(new Node(i, j));
          board[i][j] -= 2;
        }
      }
    }

    clouds = result;
  }

  private static void waterCopyBug() {
    for (Node curr : clouds) {
      int count = 0;
      for (int i = 0; i < 4; i++) {
        int ny = curr.y + ddy[i];
        int nx = curr.x + ddx[i];
        if (checkRange(ny, nx) && board[ny][nx] > 0) {
          count++;
        }
      }

      board[curr.y][curr.x] += count;
    }
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void rain() {
    for (Node curr : clouds) {
      board[curr.y][curr.x]++;
    }
  }

  private static void moveClouds(int direction, int speed) {
    List<Node> result = new ArrayList<>();

    for (Node curr : clouds) {
      int ny = (curr.y + speed * (dy[direction] + n)) % n;
      int nx = (curr.x + speed * (dx[direction] + n)) % n;
      result.add(new Node(ny, nx));
    }

    clouds = result;
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
