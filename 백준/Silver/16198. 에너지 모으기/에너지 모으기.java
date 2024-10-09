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
  static int n;
  static List<Integer> numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0));

    output();
  }

  private static int solve(int prevSum) {
    if (numbers.size() == 2) {
      return prevSum;
    }

    int result = Integer.MIN_VALUE;
    for (int i = 1; i < numbers.size() - 1; i++) {
      int acc = numbers.get(i - 1) * numbers.get(i + 1);
      int target = numbers.remove(i);
      result = Math.max(result, solve(prevSum + acc));
      numbers.add(i, target);
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    numbers = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers.add(Integer.parseInt(st.nextToken()));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}