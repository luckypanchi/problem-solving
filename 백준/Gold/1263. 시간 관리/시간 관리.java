import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] schedules;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(schedules, ((o1, o2) -> o2[1] - o1[1]));

    int currTime = Integer.MAX_VALUE;
    for (int[] currSchedule : schedules) {
      if (currTime < 0) {
        break;
      }

      int t = currSchedule[0];
      int s = currSchedule[1];

      if (currTime <= s) {
        currTime = currTime - t;
      } else {
        currTime = s - t;
      }
    }

    sb.append(currTime < 0 ? -1 : currTime);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    schedules = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      schedules[i][0] = Integer.parseInt(st.nextToken());
      schedules[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}