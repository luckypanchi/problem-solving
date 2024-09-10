import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int rowLength, colLength;
  static List<int[]> points;

  public static void main(String[] args) throws IOException {
    setUp();

    points.sort((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    int answer = 0;
    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      if (find(x + colLength, y) && find(x, y + rowLength) && find(x + colLength, y + rowLength)) {
        answer++;
      }
    }

    sb.append(answer);

    output();
  }

  private static boolean find(int targetX, int targetY) {
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int[] curr = points.get(mid);
      if (curr[0] == targetX && curr[1] == targetY) {
        return true;
      } else if (curr[0] < targetX || (curr[0] == targetX && curr[1] < targetY)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    colLength = Integer.parseInt(st.nextToken());
    rowLength = Integer.parseInt(st.nextToken());
    points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points.add(new int[]{x, y});
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}