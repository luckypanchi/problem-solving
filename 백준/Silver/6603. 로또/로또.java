import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int k;
  static int[] numbers;
  static int[] selected;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      if (k == 0) {
        break;
      }

      numbers = new int[k];
      selected = new int[6];
      for (int i = 0; i < k; i++) {
        numbers[i] = Integer.parseInt(st.nextToken());
      }

      combination(0, 0);
      sb.append("\n");
    }

    output();
  }

  private static void combination(int curr, int start) {
    if (curr == 6) {
      for (int num : selected) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < k; i++) {
      selected[curr] = numbers[i];
      combination(curr + 1, i + 1);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}