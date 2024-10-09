import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static String s;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    int curr = 0;
    int currLength = 0;
    while (curr < m - 2) {
      if (s.charAt(curr) == 'I' && s.charAt(curr + 1) == 'O' && s.charAt(curr + 2) == 'I') {
        curr += 2;
        currLength += 2;
      } else {
        curr += 1;
        currLength = 0;
      }
      if (currLength + 1 == 2 * n + 1) {
        answer++;
        currLength -= 2;
      }

    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    s = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}