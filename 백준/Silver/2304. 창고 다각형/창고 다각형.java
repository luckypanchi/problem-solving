import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] front, back;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int i = 0; i < 1002; i++) {
      answer += Math.min(front[i], back[i]);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    front = new int[1002];
    back = new int[1002];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      front[x] = h;
      back[x] = h;
    }

    for (int i = 1; i < 1002; i++) {
      front[i] = Math.max(front[i], front[i - 1]);
      int j = 1001 - i;
      back[j] = Math.max(back[j], back[j + 1]);
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}