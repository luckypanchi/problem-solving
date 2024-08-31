import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, x;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 0;
    int right = numbers.length - 1;
    int answer = 0;
    while (left < right) {
      int s = numbers[left] + numbers[right];
      if (s == x) {
        answer++;
        left++;
      } else if (s < x) {
        left++;
      } else {
        right--;
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    x = Integer.parseInt(br.readLine());
    Arrays.sort(numbers);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}