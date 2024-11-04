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
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int n, m;
  static int[][] deathZones;
  static int[][] dangerZones;

  public static void main(String[] args) throws IOException {
    setUp();

    int[][] distances = new int[501][501];
    for (int i = 0; i < 501; i++) {
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

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || isDeathZone(ny, nx)) {
          continue;
        }

        int totalCost = curr.cost;
        if (isDangerZone(ny, nx)) {
          totalCost += 1;
        }

        if (totalCost < distances[ny][nx]) {
          distances[ny][nx] = totalCost;
          pq.offer(new Pair(ny, nx, totalCost));
        }

      }
    }

    int answer = distances[500][500] == Integer.MAX_VALUE ? -1 : distances[500][500];

    sb.append(answer);
    output();
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < 501 && 0 <= x && x < 501;
  }

  private static boolean isDeathZone(int y, int x) {
    for (int i = 0; i < m; i++) {
      if (deathZones[i][0] <= y && deathZones[i][1] <= x && y <= deathZones[i][2] && x <= deathZones[i][3]) {
        return true;
      }
    }
    return false;
  }

  private static boolean isDangerZone(int y, int x) {
    for (int i = 0; i < n; i++) {
      if (dangerZones[i][0] <= y && dangerZones[i][1] <= x && y <= dangerZones[i][2] && x <= dangerZones[i][3]) {
        return true;
      }
    }
    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    dangerZones = new int[n][4];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      dangerZones[i][0] = Math.min(y1, y2);
      dangerZones[i][1] = Math.min(x1, x2);
      dangerZones[i][2] = Math.max(y1, y2);
      dangerZones[i][3] = Math.max(x1, x2);
    }
    m = Integer.parseInt(br.readLine());
    deathZones = new int[m][4];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      deathZones[i][0] = Math.min(y1, y2);
      deathZones[i][1] = Math.min(x1, x2);
      deathZones[i][2] = Math.max(y1, y2);
      deathZones[i][3] = Math.max(x1, x2);
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