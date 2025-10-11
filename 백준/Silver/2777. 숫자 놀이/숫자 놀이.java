import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());
    while (testcases-- > 0) {
      int n = Integer.parseInt(br.readLine());
      sb.append(solve(n)).append("\n");
    }

    output();
  }

  private static int solve(int target) {
    if (target == 1) {
      return 1;
    }

    int answer = 0;

    for (int mod = 9; mod > 1; mod--) {
      while (target % mod == 0) {
        target /= mod;
        answer++;
      }
    }

    return target == 1 ? answer : -1;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}