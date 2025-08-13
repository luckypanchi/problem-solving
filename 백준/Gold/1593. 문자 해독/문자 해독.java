import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static String target;
  static String s;
  static int[] targetCounter;
  static int[] counter;

  public static void main(String[] args) throws IOException {
    setUp();

    targetCounter = new int[52];
    counter = new int[52];

    for (int i = 0; i < n; i++) {
      targetCounter[toIndex(target.charAt(i))]++;
    }

    int answer = 0;
    int start = 0;

    for (int end = 0; end < m; end++) {
      counter[toIndex(s.charAt(end))]++;
      if (end - start + 1 == n) {
        if (checkCounter()) {
          answer++;
        }
        counter[toIndex(s.charAt(start))]--;
        start++;
      }
    }

    sb.append(answer);
    output();
  }

  private static boolean checkCounter() {
    for (int i = 0; i < 52; i++) {
      if (counter[i] != targetCounter[i]) {
        return false;
      }
    }
    return true;
  }

  private static int toIndex(char ch) {
    if ('a' <= ch && ch <= 'z') {
      return ch - 'a';
    } else {
      return ch - 'A' + 26;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    target = br.readLine();
    s = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}