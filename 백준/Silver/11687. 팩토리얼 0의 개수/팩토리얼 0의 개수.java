import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int m;

  public static void main(String[] args) throws IOException {
    setUp();

    int n = 0;
    int fiveCount = 0;

    while (fiveCount < m) {
      n += 5;
      fiveCount += getFiveCounts(n);
    }

    if (fiveCount == m) {
      sb.append(n);
    } else {
      sb.append(-1);
    }

    output();
  }

  private static int getFiveCounts(int target) {
    int result = 0;
    while (target % 5 == 0) {
      target = target / 5;
      result++;
    }
    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    m = Integer.parseInt(br.readLine());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}