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
  static int[][] locations;
  static int[] xList;
  static int[] yList;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(xList);
    Arrays.sort(yList);
    int targetX = xList[n / 2];
    int targetY = yList[n / 2];

    long answer = 0;
    for (int[] location : locations) {
      answer += Math.abs(targetX - location[0]) + Math.abs(targetY - location[1]);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    locations = new int[n][2];
    xList = new int[n];
    yList = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      locations[i][0] = x;
      locations[i][1] = y;
      xList[i] = x;
      yList[i] = y;
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}