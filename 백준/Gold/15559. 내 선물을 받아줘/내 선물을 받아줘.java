import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;
  static boolean[][] visited;
  static int answer = 0;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j]) {
          solve(i, j);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void solve(int startY, int startX) {
    Set<Node> currVisited = new HashSet<>();
    currVisited.add(new Node(startY, startX));

    int currY = startY;
    int currX = startX;

    while (true) {
      int ny = currY + dy[board[currY][currX]];
      int nx = currX + dx[board[currY][currX]];

      if (visited[ny][nx]) {
        for (Node prev : currVisited) {
          visited[prev.y][prev.x] = true;
        }
        return;
      }

      if (currVisited.contains(new Node(ny, nx))) {
        break;
      }

      currVisited.add(new Node(ny, nx));
      currY = ny;
      currX = nx;
    }

    for (Node prev : currVisited) {
      visited[prev.y][prev.x] = true;
    }
    answer++;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        char ch = line.charAt(j);
        board[i][j] = convertToDirection(ch);
      }
    }
  }

  private static int convertToDirection(char ch) {
    if (ch == 'N') {
      return 3;
    }
    if (ch == 'S') {
      return 1;
    }
    if (ch == 'E') {
      return 0;
    }
    if (ch == 'W') {
      return 2;
    }
    return -1;
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

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return y == node.y && x == node.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }
  }

}