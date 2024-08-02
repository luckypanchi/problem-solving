import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String balls;
  static int blueCount, redCount;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n; i++) {
      if (balls.charAt(i) == 'B') {
        blueCount++;
      } else {
        redCount++;
      }
    }

    int redLeftSideCount = count('R', true);
    int redRightSideCount = count('R', false);
    int blueLeftSideCount = count('B', true);
    int blueRightSideCount = count('B', false);

    int answer = Integer.MAX_VALUE;
    answer = Math.min(answer, redCount - redLeftSideCount);
    answer = Math.min(answer, redCount - redRightSideCount);
    answer = Math.min(answer, blueCount - blueLeftSideCount);
    answer = Math.min(answer, blueCount - blueRightSideCount);

    sb.append(answer);

    output();
  }

  private static int count(char target, boolean isLeft) {
    int[] range = rangeByDirection(isLeft);
    int result = 0;

    for (int i : range) {
      if (balls.charAt(i) != target) {
        break;
      }

      result++;
    }

    return result;
  }

  private static int[] rangeByDirection(boolean isLeft) {
    int[] range = new int[n];
    for (int i = 0; i < n; i++) {
      if (isLeft) {
        range[i] = i;
      } else {
        range[i] = n - i - 1;
      }
    }
    return range;
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    balls = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}