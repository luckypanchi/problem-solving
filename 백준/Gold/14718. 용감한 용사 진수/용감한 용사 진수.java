import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[][] stats;
  static int[] statX, statY, statZ;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = Integer.MAX_VALUE;
    for (int x : statX) {
      for (int y : statY) {
        for (int z : statZ) {
          int count = 0;
          for (int[] stat : stats) {
            if (stat[0] <= x && stat[1] <= y && stat[2] <= z) {
              count++;
            }
          }

          if (count >= k) {
            answer = Math.min(answer, x + y + z);
          }

        }
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
    stats = new int[n][3];
    statX = new int[n];
    statY = new int[n];
    statZ = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      stats[i][0] = x;
      stats[i][1] = y;
      stats[i][2] = z;

      statX[i] = x;
      statY[i] = y;
      statZ[i] = z;

    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}