import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, b, c;
  static int[] peopleCounts;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = 0;
    for (int i = 0; i < n; i++) {
      int curr = peopleCounts[i];
      answer++;
      curr -= b;
      if (0 <= curr) {
        answer += Math.ceil((double) curr / c);
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    peopleCounts = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      peopleCounts[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}