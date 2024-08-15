import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] heights;

  public static void main(String[] args) throws IOException {
    setUp();

    solve();

    output();
  }

  private static void solve() {
    Arrays.sort(heights);
    int total = Arrays.stream(heights).sum();
    for (int a = 0; a < 9; a++) {
      for (int b = a + 1; b < 9; b++) {
        if (total - heights[a] - heights[b] == 100) {
          for (int i = 0; i < 9; i++) {
            if (i == a || i == b) {
              continue;
            }
            sb.append(heights[i]).append("\n");
          }

          return;
        }
      }
    }

  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    heights = new int[9];
    for (int i = 0; i < 9; i++) {
      heights[i] = Integer.parseInt(br.readLine());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}