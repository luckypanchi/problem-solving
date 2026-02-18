import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, s;
  static int[] left, right;

  public static void main(String[] args) throws IOException {
    setUp();

    Map<Integer, Integer> leftMap = new HashMap<>();
    Map<Integer, Integer> rightMap = new HashMap<>();
    getSum(left, leftMap, 0, 0, 0);
    getSum(right, rightMap, 0, 0, 0);

    long answer = leftMap.getOrDefault(s, 0) + rightMap.getOrDefault(s, 0);
    for (int k : leftMap.keySet()) {
      if (rightMap.containsKey(s - k)) {
        answer += (long) leftMap.get(k) * rightMap.get(s - k);
      }
    }

    sb.append(answer);
    output();
  }

  private static void getSum(int[] array, Map<Integer, Integer> map, int index, int prev, int count) {
    if (index == array.length) {
      if (count == 0) {
        return;
      }
      map.put(prev, map.getOrDefault(prev, 0) + 1);
      return;
    }

    getSum(array, map, index + 1, prev + array[index], count + 1);
    getSum(array, map, index + 1, prev, count);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(numbers);
    left = Arrays.copyOfRange(numbers, 0, n / 2);
    right = Arrays.copyOfRange(numbers, n / 2, n);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}