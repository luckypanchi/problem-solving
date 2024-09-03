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
  static int m, d, k, c;
  static int[] dishes;
  static Map<Integer, Integer> counter;

  public static void main(String[] args) throws IOException {
    setUp();

    int start = 0;
    int end = 1;
    counter.put(dishes[0], 1);
    counter.put(c, 1);
    int answer = 0;
    while (start < m) {
      int length = end - start;
      if (length < k) {
        counter.put(dishes[end], counter.getOrDefault(dishes[end], 0) + 1);
        end++;
      } else if (length == k) {
        counter.put(dishes[end], counter.getOrDefault(dishes[end], 0) + 1);
        end++;
        counter.put(dishes[start], counter.get(dishes[start]) - 1);
        if (counter.get(dishes[start]) == 0) {
          counter.remove(dishes[start]);
        }
        start++;
      }

      answer = Math.max(answer, counter.size());
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    dishes = new int[2 * m];
    counter = new HashMap<>();
    for (int i = 0; i < m; i++) {
      dishes[i] = Integer.parseInt(br.readLine());
    }
    for (int i = m; i < 2 * m; i++) {
      dishes[i] = dishes[i - m];
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}