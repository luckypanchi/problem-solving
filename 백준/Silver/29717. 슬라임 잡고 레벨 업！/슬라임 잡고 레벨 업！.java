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
    for (int tc = 0; tc < testcases; tc++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(solve(n)).append("\n");
    }

    output();
  }

  private static int solve(int n) {
    long exp = (long) n * (n + 1) / 2;
    int left = 1;
    int right = n;
    int answer = 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      long currExp = (long) mid * (mid - 1);
      if (currExp <= exp) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return answer;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}