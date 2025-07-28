import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(ideaOne()).append(" ").append(ideaTwo());

    output();
  }

  private static int ideaOne() {
    Arrays.sort(numbers);
    return numbers[(n - 1) / 2];
  }

  private static int ideaTwo() {
    // 실제 평균 계산
    double sum = 0;
    for (int num : numbers) {
      sum += num;
    }
    double mean = sum / n;

    // 평균 주변의 정수 후보들
    int candidate1 = (int) Math.floor(mean);
    int candidate2 = (int) Math.ceil(mean);

    // 자연수 조건
    candidate1 = Math.max(1, candidate1);
    candidate2 = Math.max(1, candidate2);

    // 제곱합 계산 및 비교
    long sum1 = 0, sum2 = 0;
    for (int num : numbers) {
      long diff1 = num - candidate1;
      long diff2 = num - candidate2;
      sum1 += diff1 * diff1;
      sum2 += diff2 * diff2;
    }

    if (sum1 < sum2) {
      return candidate1;
    } else if (sum1 > sum2) {
      return candidate2;
    } else {
      // 동점이면 더 작은 값
      return Math.min(candidate1, candidate2);
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    numbers = new int[n];
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
