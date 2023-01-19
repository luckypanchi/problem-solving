import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[][] matrix;
  static int answer = 0;

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    matrix = new int[n][m];

    answer += n * m * 2;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < 4; k++) {
          int ny = i + dy[k];
          int nx = j + dx[k];
          if (0 <= ny && ny < n && 0 <= nx && nx < m) {
            if (matrix[i][j] < matrix[ny][nx]) {
              answer += matrix[ny][nx] - matrix[i][j];
            }
          } else {
            answer += matrix[i][j];
          }
        }
      }
    }
    System.out.println(answer);
  }
}
