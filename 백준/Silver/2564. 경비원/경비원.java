import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int h, w, n;
  static int[] matrix;
  static int start;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    n = Integer.parseInt(br.readLine());
    matrix = new int[n];

    for (int i = 0; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int tmp = 0;
      switch (r) {
        case 1:
          tmp = c;
          break;
        case 2:
          tmp = w + h + w - c;
          break;
        case 3:
          tmp = w + h + w + h - c;
          break;
        case 4:
          tmp = w + c;
          break;
      }
      if (i < n) {
        matrix[i] = tmp;
      } else {
        start = tmp;
      }
    }

    for (int i = 0; i < n; i++) {
      int p1 = Math.abs(start - matrix[i]);
      int p2 = 2 * w + 2 * h - p1;
      answer += Math.min(p1, p2);
    }
    System.out.println(answer);
  }
}
