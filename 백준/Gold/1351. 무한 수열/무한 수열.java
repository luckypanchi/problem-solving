import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static long n, p, q;
  static Map<Long, Long> dp;

  public static void main(String[] args) throws IOException {
    setUp();

    long answer = dfs(n);
    sb.append(answer);

    output();
  }

  private static long dfs(long curr) {
    if (curr == 0) {
      return 1;
    }

    if (dp.containsKey(curr)) {
      return dp.get(curr);
    }

    long result = dfs((long) Math.floor(curr / p)) + dfs((long) Math.floor(curr / q));
    dp.put(curr, result);

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Long.parseLong(st.nextToken());
    p = Long.parseLong(st.nextToken());
    q = Long.parseLong(st.nextToken());

    dp = new HashMap<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}