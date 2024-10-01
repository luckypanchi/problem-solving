import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] fruits;
  static Map<Integer, Integer> fruitCounter;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    int left = 0;
    for (int right = 0; right < n; right++) {
      fruitCounter.put(fruits[right], fruitCounter.getOrDefault(fruits[right], 0) + 1);

      while (fruitCounter.size() > 2) {
        fruitCounter.put(fruits[left], fruitCounter.get(fruits[left]) - 1);

        if (fruitCounter.get(fruits[left]) == 0) {
          fruitCounter.remove(fruits[left]);
        }

        left++;
      }

      answer = Math.max(answer, right - left + 1);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    fruits = new int[n];
    fruitCounter = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      fruits[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}