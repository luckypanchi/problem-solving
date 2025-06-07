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
  static int n, lowLimit, highLimit;
  static int[][] board;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    while (solve()) {
      answer++;
    }

    sb.append(answer);
    output();
  }

  private static boolean solve() {
    boolean[][] visited = new boolean[n][n];
    int count = 0;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (!visited[y][x] && bfs(y, x, visited)) {
          count++;
        }
      }
    }

    return count != 0;
  }

  private static boolean bfs(int startY, int startX, boolean[][] visited) {
    Deque<Node> currVisited = new ArrayDeque<>();
    Deque<Node> que = new ArrayDeque<>();

    currVisited.offer(new Node(startY, startX));
    que.offer(new Node(startY, startX));

    visited[startY][startX] = true;
    int count = 0;
    int totalSum = 0;

    while (!que.isEmpty()) {
      Node curr = que.pollFirst();

      count++;
      totalSum += board[curr.y][curr.x];

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || visited[ny][nx]) {
          continue;
        }

        int diff = Math.abs(board[curr.y][curr.x] - board[ny][nx]);

        if (diff < lowLimit || highLimit < diff) {
          continue;
        }

        visited[ny][nx] = true;
        currVisited.offer(new Node(ny, nx));
        que.offer(new Node(ny, nx));
      }
    }

    int newPopCount = totalSum / count;
    while (!currVisited.isEmpty()) {
      Node curr = currVisited.pollFirst();
      board[curr.y][curr.x] = newPopCount;
    }

    return count != 1;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    lowLimit = Integer.parseInt(st.nextToken());
    highLimit = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
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

  private static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}