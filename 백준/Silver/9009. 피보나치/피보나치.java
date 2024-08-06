import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static List<Integer> factorials;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    factorials = new ArrayList<>();
    factorials.add(0);
    factorials.add(1);
    while (factorials.get(factorials.size() - 1) < 1000000000) {
      factorials.add(factorials.get(factorials.size() - 1) + factorials.get(factorials.size() - 2));
    }
    Collections.reverse(factorials);

    int tcs = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < tcs; tc++) {
      int n = Integer.parseInt(br.readLine());
      List<Integer> answer = new ArrayList<>();

      int i = 0;
      while (n != 0) {
        if (factorials.get(i + 1) <= n && n < factorials.get(i)) {
          n -= factorials.get(i + 1);
          answer.add(factorials.get(i + 1));
        }
        i++;
      }

      Collections.reverse(answer);
      for (int ans : answer) {
        sb.append(ans).append(" ");
      }
      sb.append("\n");
    }

    output();
  }

  private static int solve(int n) {
    return 0;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}