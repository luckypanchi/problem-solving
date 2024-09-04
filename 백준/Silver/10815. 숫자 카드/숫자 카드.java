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
  static int[] cards, sg;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(cards);
    for (int target : sg) {
      if (check(target)) {
        sb.append(1);
      } else {
        sb.append(0);
      }

      sb.append(" ");
    }

    output();
  }

  private static boolean check(int target) {
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (cards[mid] == target) {
        return true;
      } else if (cards[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    cards = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    m = Integer.parseInt(br.readLine());
    sg = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      sg[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}