import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m, r;
  static int[][] matrix;
  static int[] operators;

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
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < r; i++) {
      operation(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(matrix[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void operation(int number) {
    if (number == 3 || number == 4) {
      int tmp = n;
      n = m;
      m = tmp;
    }

    int[][] newMatrix = new int[n][m];
    int midN = n / 2;
    int midM = m / 2;

    switch (number) {
      case 1:
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            newMatrix[n - 1 - i][j] = matrix[i][j];
          }
        }
        break;
      case 2:
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            newMatrix[i][m - 1 - j] = matrix[i][j];
          }
        }
        break;
      case 3:
        for (int j = 0; j < n; j++) {
          for (int i = 0; i < m; i++) {
            newMatrix[j][m - 1 - i] = matrix[i][j];
          }
        }
        break;
      case 4:
        for (int j = 0; j < n; j++) {
          for (int i = 0; i < m; i++) {
            newMatrix[n - 1 - j][i] = matrix[i][j];
          }
        }
        break;
      case 5:
        for (int i = 0; i < midN; i++) {
          for (int j = 0; j < midM; j++) {
            newMatrix[i][j + midM] = matrix[i][j];
          }
        }
        for (int i = 0; i < midN; i++) {
          for (int j = midM; j < m; j++) {
            newMatrix[i + midN][j] = matrix[i][j];
          }
        }
        for (int i = midN; i < n; i++) {
          for (int j = midM; j < m; j++) {
            newMatrix[i][j - midM] = matrix[i][j];
          }
        }
        for (int i = midN; i < n; i++) {
          for (int j = 0; j < midM; j++) {
            newMatrix[i - midN][j] = matrix[i][j];
          }
        }
        break;
      case 6:
        for (int i = 0; i < midN; i++) {
          for (int j = 0; j < midM; j++) {
            newMatrix[i + midN][j] = matrix[i][j];
          }
        }
        for (int i = midN; i < n; i++) {
          for (int j = 0; j < midM; j++) {
            newMatrix[i][j + midM] = matrix[i][j];
          }
        }
        for (int i = midN; i < n; i++) {
          for (int j = midM; j < m; j++) {
            newMatrix[i - midN][j] = matrix[i][j];
          }
        }
        for (int i = 0; i < midN; i++) {
          for (int j = midM; j < m; j++) {
            newMatrix[i][j - midM] = matrix[i][j];
          }
        }
        break;
    }

    matrix = newMatrix;
  }
}
