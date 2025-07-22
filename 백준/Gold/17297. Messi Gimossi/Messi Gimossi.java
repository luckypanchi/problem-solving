import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int m;
  static List<Integer> dp;

  static final String FIRST = "Messi";
  static final String SECOND = "Messi Gimossi";

  public static void main(String[] args) throws IOException {
    setUp();

    int pprev = 5;
    int prev = 13;
    dp.add(pprev);
    dp.add(prev);

    while (true) {
      int curr = pprev + 1 + prev;
      dp.add(curr);
      if (m < curr) {
        break;
      }
      pprev = prev;
      prev = curr;
    }

    char result = solve(dp.size() - 1, m);

    if (result == ' ') {
      sb.append("Messi Messi Gimossi");
    } else {
      sb.append(result);
    }

    output();
  }

  private static char solve(int stringIndex, int targetIndex) {
    if (stringIndex == 0) {
      return FIRST.charAt(targetIndex);
    }
    if (stringIndex == 1) {
      return SECOND.charAt(targetIndex);
    }

    int prev = dp.get(stringIndex - 1);

    if (targetIndex == prev) {
      return ' ';
    } else if (targetIndex < prev) {
      return solve(stringIndex - 1, targetIndex);
    } else {
      return solve(stringIndex - 2, targetIndex - prev - 1);
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    m = Integer.parseInt(br.readLine()) - 1;
    dp = new ArrayList<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}