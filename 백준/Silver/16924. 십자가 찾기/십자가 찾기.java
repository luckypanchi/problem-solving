import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static char[][] matrix;
  static int[][] visited;

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    matrix = new char[n][m];
    visited = new int[n][m];

    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        matrix[i][j] = row.charAt(j);
      }
    }

    int count = 0;
    ArrayList<Integer[]> answer = new ArrayList<>();

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        int d = 1;
        if (matrix[i][j] == '*' && check(i, j, d)) {
          count++;
          mark(i, j, 0);
          mark(i, j, d);
          while (true) {
            d++;
            if (!check(i, j, d)) {
              d--;
              break;
            }
            mark(i, j, d);
          }
          answer.add(new Integer[] { i + 1, j + 1, d });
        }
      }
    }

    if (checkMarked()) {
      sb.append(-1);
    } else {
      sb.append(count).append("\n");
      for (int i = 0; i < answer.size(); i++) {
        Integer[] arr = answer.get(i);
        for (int j = 0; j < 3; j++) {
          sb.append(arr[j]).append(' ');
        }
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  static boolean check(int y, int x, int dir) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i] * dir;
      int nx = x + dx[i] * dir;
      if (!(0 <= ny && ny < n && 0 <= nx && nx < m && matrix[ny][nx] == '*')) {
        return false;
      }
    }
    return true;
  }

  static void mark(int y, int x, int dir) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i] * dir;
      int nx = x + dx[i] * dir;
      visited[ny][nx] = 1;
    }
  }

  static boolean checkMarked() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '*' && visited[i][j] == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
