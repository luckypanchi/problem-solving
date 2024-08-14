import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] target;

  public static void main(String[] args) throws IOException {
    setUp();

    if (nextPermutation()) {
      for (int num : target) {
        sb.append(num).append(" ");
      }
    } else {
      sb.append(-1);
    }

    output();
  }

  private static boolean nextPermutation() {
    int i = n - 1;
    while (i > 0 && target[i - 1] >= target[i]) {
      i--;
    }

    if (i == 0) {
      return false;
    }

    int j = n - 1;
    while (target[i - 1] >= target[j]) {
      j--;
    }

    swap(i - 1, j);
    reverse(i, n - 1);

    return true;
  }

  private static void reverse(int start, int end) {
    while (start < end) {
      swap(start++, end--);
    }
  }

  private static void swap(int a, int b) {
    int temp = target[a];
    target[a] = target[b];
    target[b] = temp;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    target = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      target[i] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}