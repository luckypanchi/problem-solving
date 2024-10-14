import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 0;
    int right = 0;
    int count = 0;
    int answer = 0;

    while (right < n) {
      if (numbers[right] % 2 == 0) {
        right++;
        answer = Math.max(answer, right - left - count);
      } else if (numbers[right] % 2 != 0 && count < k) {
        count++;
        right++;
        answer = Math.max(answer, right - left - count);
      } else if (numbers[left] % 2 == 0) {
        left++;
      } else {
        count--;
        left++;
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}