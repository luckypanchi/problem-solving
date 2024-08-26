import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static long answer;
  static int[] array;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = 0L;
    while (2 < n && !dfs()) {
    }

    sb.append(answer);

    output();
  }

  private static boolean dfs() {
    boolean result = true;

    for (int i = 1; i < n - 1; i++) {
      if (!check(i)) {
        int diff = array[i] - (array[i - 1] + array[i + 1]) / 2;
        answer += diff;
        array[i] -= diff;
        result = false;
      }
    }

    return result;
  }

  private static boolean check(int index) {
    return array[index - 1] + array[index + 1] >= 2 * array[index];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    array = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}