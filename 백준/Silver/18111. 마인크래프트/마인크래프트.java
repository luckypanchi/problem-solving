import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m, b;
  static int[][] matrix;
  static int answerTime = Integer.MAX_VALUE;
  static int answerHeight = Integer.MIN_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    matrix = new int[n][m];

    int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
        minHeight = Math.min(minHeight, matrix[i][j]);
        maxHeight = Math.max(maxHeight, matrix[i][j]);
      }
    }

    for (int h = minHeight; h < maxHeight + 1; h++) {
      solution(h);
    }

    System.out.printf("%d %d", answerTime, answerHeight);
  }

  public static void solution(int targetHeight) {
    int time = 0;
    int inventory = b;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (targetHeight < matrix[i][j]) {
          int diff = matrix[i][j] - targetHeight;
          inventory += diff;
          time += diff * 2;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] < targetHeight) {
          int diff = targetHeight - matrix[i][j];
          if (diff <= inventory) {
            inventory -= diff;
            time += diff;
          } else {
            return;
          }
        }
      }
    }

    if (time < answerTime) {
      answerHeight = targetHeight;
      answerTime = time;
    } else if (time == answerTime) {
      answerHeight = Math.max(answerHeight, targetHeight);
    }
  }
}
