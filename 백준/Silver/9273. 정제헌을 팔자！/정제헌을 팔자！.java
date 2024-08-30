import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      try {
        String s = br.readLine();
        int n = Integer.parseInt(s.split("/")[1]);

        sb.append(solve(n)).append("\n");
      } catch (Exception e) {
        break;
      }
    }

    output();
  }

  private static int solve(int n) {
    int count = 0;
    for (int x = n + 1; x < 2 * n + 1; x++) {
      if ((n * x) % (x - n) == 0) {
        count++;
      }
    }

    return count;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}