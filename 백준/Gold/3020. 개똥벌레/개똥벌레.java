import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, h;
  static int[] heights;

  public static void main(String[] args) throws IOException {
    setUp();

    int minCount = Integer.MAX_VALUE;
    int count = 0;
    for (int i = 1; i < h + 1; i++) {
      if (heights[i] < minCount) {
        minCount = heights[i];
        count = 1;
      } else if (heights[i] == minCount) {
        count++;
      }
    }

    sb.append(minCount).append(" ").append(count);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    heights = new int[h + 2];

    for (int i = 0; i < n; i++) {
      int curr = Integer.parseInt(br.readLine());
      if (i % 2 == 0) {
        heights[1] += 1;
        heights[curr + 1] -= 1;
      } else {
        heights[h - curr + 1] += 1;
        heights[h + 1] -= 1;
      }
    }

    for (int i = 1; i < h + 2; i++) {
      heights[i] += heights[i - 1];
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}