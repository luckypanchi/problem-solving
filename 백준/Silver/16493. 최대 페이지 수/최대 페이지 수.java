import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static Chapter[] chapters;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, 0));

    output();
  }

  private static int solve(int curr, int leftDays) {
    if (n < leftDays) {
      return -50_000;
    }
    if (curr == m) {
      return 0;
    }

    return Math.max(chapters[curr].page + solve(curr + 1, leftDays + chapters[curr].day), solve(curr + 1, leftDays));
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    chapters = new Chapter[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int day = Integer.parseInt(st.nextToken());
      int page = Integer.parseInt(st.nextToken());
      chapters[i] = new Chapter(day, page);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Chapter {

    int day, page;

    public Chapter(int day, int page) {
      this.day = day;
      this.page = page;
    }
  }

}