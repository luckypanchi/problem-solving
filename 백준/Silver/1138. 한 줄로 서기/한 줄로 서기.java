import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] taller;
  static int[] answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    taller = new int[n];
    answer = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      taller[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (answer[j] == 0 && taller[i] <= count) {
          answer[j] = i + 1;
          break;
        }
        if (answer[j] == 0) {
          count++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      sb.append(answer[i]).append(" ");
    }
    System.out.println(sb);
  }
}
