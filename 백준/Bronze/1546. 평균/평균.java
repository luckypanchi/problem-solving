import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] numbers = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (max < num) max = num;
      numbers[i] = num;
    }

    double answer = 0;
    for (int i = 0; i < n; i++) {
      answer += (double) (numbers[i]) / max * 100;
    }

    System.out.println(answer / n);
  }
}
