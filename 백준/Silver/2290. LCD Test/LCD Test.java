import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int s;
  static int width;
  static int height;
  static int mid;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    String n = st.nextToken();

    width = s + 2;
    height = 2 * s + 3;
    mid = height / 2;

    int total_width = n.length() * (width + 1);
    char[][] answer = new char[height][total_width];

    for (int i = 0; i < n.length(); i++) {
      char[][] number = create(n.charAt(i));
      int start = (width + 1) * i;
      for (int j = 0; j < height; j++) {
        for (int k = 0; k < width; k++) {
          answer[j][start + k] = number[j][k];
        }
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < total_width; j++) {
        if (answer[i][j] == '|' || answer[i][j] == '-') {
          sb.append(answer[i][j]);
        } else {
          sb.append(" ");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static char[][] create(char num) {
    char[][] number = new char[height][width];
    switch (num) {
      case '1':
        for (int i = 1; i < mid; i++) {
          number[i][width - 1] = '|';
          number[mid + i][width - 1] = '|';
        }
        break;
      case '2':
        for (int i = 1; i < mid; i++) {
          number[i][width - 1] = '|';
          number[mid + i][0] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '3':
        for (int i = 1; i < mid; i++) {
          number[i][width - 1] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '4':
        for (int i = 1; i < mid; i++) {
          number[i][width - 1] = '|';
          number[i][0] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[mid][i] = '-';
        }
        break;
      case '5':
        for (int i = 1; i < mid; i++) {
          number[i][0] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '6':
        for (int i = 1; i < mid; i++) {
          number[i][0] = '|';
          number[mid + i][0] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '7':
        for (int i = 1; i < mid; i++) {
          number[i][width - 1] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
        }
        break;
      case '8':
        for (int i = 1; i < mid; i++) {
          number[i][0] = '|';
          number[i][width - 1] = '|';
          number[mid + i][0] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '9':
        for (int i = 1; i < mid; i++) {
          number[i][0] = '|';
          number[i][width - 1] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[mid][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
      case '0':
        for (int i = 1; i < mid; i++) {
          number[i][0] = '|';
          number[i][width - 1] = '|';
          number[mid + i][0] = '|';
          number[mid + i][width - 1] = '|';
        }
        for (int i = 1; i < width - 1; i++) {
          number[0][i] = '-';
          number[height - 1][i] = '-';
        }
        break;
    }
    return number;
  }
}
