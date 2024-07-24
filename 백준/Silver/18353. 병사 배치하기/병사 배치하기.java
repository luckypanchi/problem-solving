import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] attacks;
  static int[] tmp;

  public static void main(String[] args) throws IOException {
    setUp();

    int tmpIndex = 0;
    tmp[0] = attacks[0];

    for (int index = 1; index < n; index++) {
      if (tmp[tmpIndex] > attacks[index]) {
        tmp[++tmpIndex] = attacks[index];
      } else {
        int pos = binarySearch(0, tmpIndex, attacks[index]);
        tmp[pos] = attacks[index];
      }
    }

    sb.append(n - (tmpIndex + 1));

    output();
  }

  private static int binarySearch(int left, int right, int target) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (tmp[mid] > target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    attacks = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      attacks[i] = Integer.parseInt(st.nextToken());
    }
    tmp = new int[n];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}