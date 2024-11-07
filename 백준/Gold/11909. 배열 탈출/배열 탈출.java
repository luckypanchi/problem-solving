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
  static int n;
  static int[][] board;
  static int[] dx = {1, 0};
  static int[] dy = {0, 1};

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dijkstra());

    output();
  }

  private static int dijkstra() {
    int[][] distances = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(distances[i], Integer.MAX_VALUE);
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    distances[0][0] = 0;
    pq.offer(new Pair(0, 0, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.y][curr.x] < curr.cost) {
        continue;
      }

      for (int i = 0; i < 2; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];
        if (!checkRange(ny, nx)) {
          continue;
        }

        int totalCost = curr.cost;
        if (board[curr.y][curr.x] <= board[ny][nx]) {
          totalCost += board[ny][nx] - board[curr.y][curr.x] + 1;
        }

        if (totalCost < distances[ny][nx]) {
          distances[ny][nx] = totalCost;
          pq.offer(new Pair(ny, nx, totalCost));
        }
      }
    }

    return distances[n - 1][n - 1];
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
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

  private static class Pair {

    int y, x, cost;

    public Pair(int y, int x, int cost) {
      this.y = y;
      this.x = x;
      this.cost = cost;
    }
  }

}