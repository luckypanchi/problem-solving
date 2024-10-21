import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static char[][] board;
  static int[] start, dest;
  static int[] dx = new int[]{1, 0, -1, 0};
  static int[] dy = new int[]{0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int[][][] mirrorCounts = new int[n][n][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(mirrorCounts[i][j], Integer.MAX_VALUE);
      }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < 4; i++) {
      pq.offer(new Pair(start[0], start[1], i, 0));
      mirrorCounts[start[0]][start[1]][i] = 0;
    }

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (mirrorCounts[curr.y][curr.x][curr.d] < curr.mirrorCount) {
        continue;
      }

      int[] nextDirections;
      if (board[curr.y][curr.x] == '!') {
        nextDirections = new int[]{curr.d, (curr.d + 1) % 4, (curr.d + 3) % 4};
      } else {
        nextDirections = new int[]{curr.d};
      }

      for (int i : nextDirections) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];
        int count = curr.mirrorCount;
        if (i != curr.d) {
          count++;
        }

        if (rangeCheck(ny, nx) && board[ny][nx] != '*' && count < mirrorCounts[ny][nx][i]) {
          mirrorCounts[ny][nx][i] = count;
          pq.offer(new Pair(ny, nx, i, count));
        }
      }
    }

    sb.append(Arrays.stream(mirrorCounts[dest[0]][dest[1]]).min().getAsInt());
    output();
  }

  private static boolean rangeCheck(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new char[n][n];
    start = new int[]{-1, -1};
    dest = new int[]{-1, -1};
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = row.charAt(j);
        if (board[i][j] == '#') {
          if (start[0] == -1 && start[1] == -1) {
            start = new int[]{i, j};
          } else {
            dest = new int[]{i, j};
          }
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

    int y, x, d, mirrorCount;

    public Pair(int y, int x, int d, int mirrorCount) {
      this.y = y;
      this.x = x;
      this.d = d;
      this.mirrorCount = mirrorCount;
    }

    @Override
    public int compareTo(Pair o) {
      return this.mirrorCount - o.mirrorCount;
    }
  }

}