import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, s;
  static int[] array;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int targetIndex = 0; targetIndex < n; targetIndex++) {
      if (s <= 0) {
        break;
      }

      int maxIndex = targetIndex;
      int count = 0;

      int c = 0;
      for (int i = targetIndex + 1; i < n; i++) {
        c++;
        if (s < c) {
          break;
        }

        if (array[maxIndex] < array[i]) {
          maxIndex = i;
          count = c;
        }

      }

      swap(targetIndex, maxIndex);
      s -= count;

    }

    for (int num : array) {
      sb.append(num).append(" ");
    }

    output();
  }

  private static void swap(int small, int big) {
    for (int i = big; i > small; i--) {
      int temp = array[i];
      array[i] = array[i - 1];
      array[i - 1] = temp;
    }

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
    s = Integer.parseInt(br.readLine());

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}