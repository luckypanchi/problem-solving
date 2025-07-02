import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] belt;
  static boolean[] robots;

  static int startPointer, endPointer;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    while (true) {
      answer++;

      startPointer = (startPointer - 1 + 2 * n) % (2 * n);
      endPointer = (endPointer - 1 + 2 * n) % (2 * n);

      robots[endPointer] = false;

      if (startPointer < endPointer) {
        for (int i = endPointer - 1; i > startPointer - 1; i--) {
          if (robots[i] && !robots[i + 1] && 1 <= belt[i + 1]) {
            robots[i + 1] = true;
            belt[i + 1]--;
            robots[i] = false;
          }
        }
      } else {
        for (int i = endPointer - 1; i > -1; i--) {
          if (robots[i] && !robots[i + 1] && 1 <= belt[i + 1]) {
            robots[i + 1] = true;
            belt[i + 1]--;
            robots[i] = false;
          }
        }

        if (robots[2 * n - 1] && !robots[0] && 1 <= belt[0]) {
          robots[0] = true;
          belt[0]--;
          robots[2 * n - 1] = false;
        }

        for (int i = 2 * n - 2; i > startPointer - 1; i--) {
          if (robots[i] && !robots[i + 1] && 1 <= belt[i + 1]) {
            robots[i + 1] = true;
            belt[i + 1]--;
            robots[i] = false;
          }
        }
      }

      robots[endPointer] = false;

      if (1 <= belt[startPointer]) {
        robots[startPointer] = true;
        belt[startPointer]--;
      }

      int zeroCounter = (int) Arrays.stream(belt).filter(n -> n == 0).count();

      if (k <= zeroCounter) {
        break;
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    belt = new int[2 * n];
    robots = new boolean[2 * n];
    startPointer = 0;
    endPointer = n - 1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * n; i++) {
      belt[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}