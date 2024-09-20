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
  static int n, k;
  static int currIndex;
  static List<Integer> selected;

  public static void main(String[] args) throws IOException {
    setUp();

    permutations(n);

    if (sb.length() == 0) {
      sb.append(-1);
    }

    output();
  }

  private static boolean permutations(int target) {
    if (target < 0) {
      return false;
    }
    if (target == 0) {
      if (currIndex == k) {
        for (int num : selected) {
          sb.append(num).append('+');
        }
        sb.deleteCharAt(sb.length() - 1);
        return true;
      }
      currIndex++;
      return false;
    }

    for (int i = 1; i < 4; i++) {
      selected.add(i);
      if (permutations(target - i)) {
        return true;
      }
      selected.remove(selected.size() - 1);
    }
    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    currIndex = 1;
    selected = new ArrayList<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}