import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, length, k;
  static int[][] stars;
  static int[] starX, starY;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int x : starX) {
      for (int y : starY) {
        answer = Math.max(answer, count(x, y));
      }
    }

    sb.append(k - answer);

    output();
  }

  private static int count(int startX, int startY) {
    int result = 0;
    for (int[] star : stars) {
      if (startX <= star[0] && star[0] <= startX + length && startY <= star[1] && star[1] <= startY + length) {
        result++;
      }
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    length = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    stars = new int[k][2];
    starX = new int[k];
    starY = new int[k];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      stars[i][0] = x;
      stars[i][1] = y;

      starX[i] = x;
      starY[i] = y;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}