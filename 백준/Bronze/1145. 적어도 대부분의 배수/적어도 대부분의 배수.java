import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = Arrays.stream(numbers).min().getAsInt();
    while (true) {
      int count = 0;
      for (int num : numbers) {
        if (answer % num == 0) {
          count++;
        }
      }

      if (count >= 3) {
        break;
      }

      answer++;
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    numbers = new int[5];
    for (int i = 0; i < 5; i++) {
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