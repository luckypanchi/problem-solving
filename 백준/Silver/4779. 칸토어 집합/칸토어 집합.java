import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static char[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      try {
        n = Integer.parseInt(br.readLine());
        int length = (int) Math.pow(3, n);
        answer = new char[length];
        Arrays.fill(answer, ' ');
        solve(0, length);

        for (char c : answer) {
          sb.append(c);
        }
        sb.append("\n");

      } catch (Exception e) {
        break;
      }
    }

    output();
  }

  private static void solve(int start, int end) {
    if (start + 1 == end) {
      answer[start] = '-';
      return;
    }

    int length = (end - start) / 3;
    solve(start, start + length);
    solve(start + 2 * length, end);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}