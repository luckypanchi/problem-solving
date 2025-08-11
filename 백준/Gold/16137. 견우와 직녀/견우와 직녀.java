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
  static int[][][] visited;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(bfs());

    output();
  }

  private static int bfs() {
    Deque<Node> que = new ArrayDeque<>();
    que.add(new Node(0, 0, 0, false));

    while (!que.isEmpty()) {
      Node cur = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];

        if (!checkRange(ny, nx)) {
          continue;
        }

        int nextTime = visited[cur.y][cur.x][cur.count] + 1;

        if (board[ny][nx] == 1 && (visited[ny][nx][cur.count] == 0 || nextTime < visited[ny][nx][cur.count])) {
          visited[ny][nx][cur.count] = nextTime;
          que.add(new Node(ny, nx, cur.count, false));
        }

        if (board[ny][nx] > 1 && (visited[ny][nx][cur.count] == 0 || nextTime < visited[ny][nx][cur.count]) && !cur.prev) {
          visited[ny][nx][cur.count] = getCrossTime(nextTime, board[ny][nx]);
          que.add(new Node(ny, nx, cur.count, true));
        }

        if (board[ny][nx] == 0 && cur.count == 0 && (visited[ny][nx][1] == 0 || nextTime < visited[ny][nx][1]) && !cur.prev && !isCrossed(ny, nx)) {
          visited[ny][nx][1] = getCrossTime(nextTime, m);
          que.add(new Node(ny, nx, 1, true));
        }
      }
    }

    if (visited[n - 1][n - 1][0] == 0) {
      return visited[n - 1][n - 1][1];
    }

    if (visited[n - 1][n - 1][1] == 0) {
      return visited[n - 1][n - 1][0];
    }

    return Math.min(visited[n - 1][n - 1][0], visited[n - 1][n - 1][1]);
  }

  private static int getCrossTime(int currTime, int freq) {
    while (currTime % freq != 0) {
      currTime++;
    }
    return currTime;
  }

  private static boolean isCrossed(int y, int x) {
    if (board[y][x] != 0) {
      return true;
    }

    int count1 = 0;
    for (int i = 0; i < 4; i += 2) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (!checkRange(ny, nx)) {
        continue;
      }
      if (board[ny][nx] != 1) {
        count1++;
      }
    }

    int count2 = 0;
    for (int i = 1; i < 4; i += 2) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (!checkRange(ny, nx)) {
        continue;
      }
      if (board[ny][nx] != 1) {
        count2++;
      }
    }

    return count1 > 0 && count2 > 0;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    visited = new int[n][n][2];
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

    int y, x, count;
    boolean prev;

    public Node(int y, int x, int count, boolean prev) {
      this.y = y;
      this.x = x;
      this.count = count;
      this.prev = prev;
    }
  }

}

/*
8 2
1 1 1 1 0 1 1 1
1 1 0 1 0 1 0 1
0 0 0 1 1 1 0 1
0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 1
0 0 0 0 0 1 1 1
0 0 0 0 0 0 0 10
0 0 0 0 0 0 1 1
Answer = 20;

3 3
1 1 1
1 1 1
1 1 1
Answer = 4;

5 5
1 2 1 2 1
1 2 1 2 1
1 2 1 2 1
1 2 1 2 1
1 2 1 2 1
Answer = 8;

4 3
1 1 100 100
1 1 100 100
0 0 1 1
1 0 1 1
Answer = 103

4 3
1 1 20 20
1 1 20 20
0 0 1 1
1 0 1 1
Answer = 23;

5 10
1 1 2 3 1
1 1 0 0 1
13 0 0 0 1
1 1 1 1 1
1 1 1 1 1
Answer = 15;

2 2
1 0
0 1
답 3
 */