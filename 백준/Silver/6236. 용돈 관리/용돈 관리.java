import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] money;

  public static void main(String[] args) throws IOException {
    setUp();

    int start = Arrays.stream(money).max().getAsInt();
    int end = Arrays.stream(money).sum();
    int answer = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (count(mid) <= m) {
        answer = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    sb.append(answer);

    output();
  }

  private static int count(int criterion) {
    int cnt = 0;
    int curr = 0;

    for (int expected : money) {
      if (curr < expected) {
        cnt++;
        curr = criterion;
      }

      curr -= expected;
    }

    return cnt;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    money = new int[n];
    for (int i = 0; i < n; i++) {
      money[i] = Integer.parseInt(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}