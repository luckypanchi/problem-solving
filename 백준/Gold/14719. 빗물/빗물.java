import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int h, w;
  static int[] heights, prefixMax, suffixMax;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 1; i < w + 1; i++) {
      prefixMax[i] = Math.max(heights[i], prefixMax[i - 1]);
      int j = w + 1 - i;
      suffixMax[j] = Math.max(heights[j], suffixMax[j + 1]);
    }

    int answer = 0;
    for (int i = 1; i < w + 1; i++) {
      answer += Math.min(prefixMax[i], suffixMax[i]) - heights[i];
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    heights = new int[w + 2];
    prefixMax = new int[w + 2];
    suffixMax = new int[w + 2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < w + 1; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}