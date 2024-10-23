import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, t, d;
  static int[][] board;
  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};
  static int[][][][] distances;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int startY = 0; startY < n; startY++) {
      for (int startX = 0; startX < m; startX++) {
        dijkstra(startY, startX);
      }
    }

    int answer = 0;
    for (int endY = 0; endY < n; endY++) {
      for (int endX = 0; endX < m; endX++) {
        int totalTimeCost = distances[0][0][endY][endX] + distances[endY][endX][0][0];
        if (0 <= totalTimeCost && totalTimeCost <= d) {
          answer = Math.max(answer, board[endY][endX]);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void dijkstra(int startY, int startX) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();

    distances[startY][startX][startY][startX] = 0;
    pq.offer(new Pair(startY, startX, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[startY][startX][curr.y][curr.x] < curr.cost) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || t < Math.abs(board[ny][nx] - board[curr.y][curr.x])) {
          continue;
        }

        int totalCost = curr.cost;
        if (board[curr.y][curr.x] < board[ny][nx]) {
          totalCost += (int) Math.pow(board[ny][nx] - board[curr.y][curr.x], 2);
        } else {
          totalCost += 1;
        }

        if (totalCost < distances[startY][startX][ny][nx] && totalCost <= d) {
          distances[startY][startX][ny][nx] = totalCost;
          pq.offer(new Pair(ny, nx, totalCost));
        }
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
    t = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    distances = new int[n][m][n][m];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        char curr = row.charAt(j);
        if ('A' <= curr && curr <= 'Z') {
          board[i][j] = curr - 'A';
        } else if ('a' <= curr && curr <= 'z') {
          board[i][j] = curr - 'a' + 26;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < n; k++) {
          Arrays.fill(distances[i][j][k], Integer.MAX_VALUE);
        }
      }
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair implements Comparable<Pair> {

    int y, x, cost;

    public Pair(int y, int x, int cost) {
      this.y = y;
      this.x = x;
      this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
      return this.cost - o.cost;
    }
  }

}