import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, m, r;
  static int[][] matrix;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    matrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int sy = 0;
    int sx = 0;
    int dy = n - 1;
    int dx = m - 1;

    while (sy < dy && sx < dx) {
      rotate(sy, sx, dy, dx);
      sy++;
      sx++;
      dy--;
      dx--;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(matrix[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void rotate(int sy, int sx, int dy, int dx) {
    Queue<Integer> que = new LinkedList<>();
    for (int i = sx; i < dx; i++) {
      que.add(matrix[sy][i]);
    }
    for (int i = sy; i < dy; i++) {
      que.add(matrix[i][dx]);
    }
    for (int i = dx; i > sx; i--) {
      que.add(matrix[dy][i]);
    }
    for (int i = dy; i > sy; i--) {
      que.add(matrix[i][sx]);
    }

    for (int i = 0; i < r; i++) {
      que.add(que.poll());
    }

    for (int i = sx; i < dx; i++) {
      matrix[sy][i] = que.poll();
    }
    for (int i = sy; i < dy; i++) {
      matrix[i][dx] = que.poll();
    }
    for (int i = dx; i > sx; i--) {
      matrix[dy][i] = que.poll();
    }
    for (int i = dy; i > sy; i--) {
      matrix[i][sx] = que.poll();
    }
  }
}
