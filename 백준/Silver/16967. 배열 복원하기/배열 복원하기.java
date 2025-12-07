import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int h, w, x, y;
  static int[][] a, b;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (isCombined(i, j)) {
          a[i][j] = b[i][j] - a[i - x][j - y];
        } else {
          a[i][j] = b[i][j];
        }
      }
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        sb.append(a[i][j]).append(" ");
      }
      sb.append("\n");
    }

    output();
  }

  private static boolean isCombined(int currY, int currX) {
    return x <= currY && currY < h && y <= currX && currX < w;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    a = new int[h][w];
    b = new int[h + x][w + y];
    for (int i = 0; i < h + x; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w + y; j++) {
        b[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}