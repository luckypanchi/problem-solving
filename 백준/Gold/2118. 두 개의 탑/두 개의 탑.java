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

    int total = Arrays.stream(numbers).sum();
    int answer = 0;
    for (int start = 0; start < n - 1; start++) {
      int dist = 0;
      for (int end = start; end < n - 1; end++) {
        dist += numbers[end];
        int curr = Math.min(dist, total - dist);
        answer = Math.max(answer, curr);
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
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}