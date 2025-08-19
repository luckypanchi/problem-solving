import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());

    for (int i = 0; i < testcases; i++) {
      st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      sb.append("Case #").append(i + 1).append(": ").append(solve(a, b, n)).append("\n");
    }

    output();
  }

  private static long solve(long start, long end, int target) {
    List<Integer> divided = div(target);

    long answer = end - start + 1;
    for (int i = 1; i < divided.size() + 1; i++) {
      List<Long> comb = comb(0, 0, i, 1L, divided);
      for (long d : comb) {
        if (i % 2 != 0) {
          answer = answer - (end / d - (start - 1) / d);
        } else {
          answer = answer + (end / d - (start - 1) / d);
        }
      }
    }

    return answer;
  }

  private static List<Long> comb(int curr, int start, int count, Long prev, List<Integer> divided) {
    if (curr == count) {
      return List.of(prev);
    }

    List<Long> result = new ArrayList<>();
    for (int i = start; i < divided.size(); i++) {
      result.addAll(comb(curr + 1, i + 1, count, prev * divided.get(i), divided));
    }
    return result;
  }

  private static List<Integer> div(int target) {
    List<Integer> result = new ArrayList<>();
    for (int i = 2; i < (int) Math.sqrt(target) + 1; i++) {
      if (target % i == 0) {
        result.add(i);
        while (target % i == 0) {
          target /= i;
        }
      }
    }

    if (target > 1) {
      result.add(target);
    }

    return result;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}