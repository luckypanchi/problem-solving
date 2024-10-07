import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static String target;
  static Map<Character, Integer> counter;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    int start = 0;
    int end = 0;

    while (end < target.length()) {
      if (counter.size() <= n) {
        char curr = target.charAt(end);
        if (counter.containsKey(curr)) {
          counter.put(curr, counter.get(curr) + 1);
        } else {
          counter.put(curr, 1);
        }
        end++;
      } else {
        char curr = target.charAt(start);
        counter.put(curr, counter.get(curr) - 1);
        if (counter.get(curr) == 0) {
          counter.remove(curr);
        }
        start++;
      }

      if (counter.size() <= n) {
        answer = Math.max(answer, end - start);
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    target = br.readLine();
    counter = new HashMap<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}