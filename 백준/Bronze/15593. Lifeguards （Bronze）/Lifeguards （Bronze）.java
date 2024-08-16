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
  static int[][] covers;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int target = 0; target < n; target++) {
      int[] isCovered = new int[1001];
      for (int i = 0; i < n; i++) {
        if (i == target) {
          continue;
        }

        for (int j = covers[i][0]; j < covers[i][1]; j++) {
          if (isCovered[j] == 0) {
            isCovered[j] = 1;
          }
        }
      }

      answer = Math.max(answer, Arrays.stream(isCovered).sum());
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    covers = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      covers[i][0] = Integer.parseInt(st.nextToken());
      covers[i][1] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}