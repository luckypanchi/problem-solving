import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, c;
  static int[] weights;
  static Set<Integer> set;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve() ? 1 : 0);

    output();
  }

  private static boolean solve() {
    if (set.contains(c)) {
      return true;
    }

    for (int i = 0; i < n; i++) {
      int remain = c - weights[i];
      if (weights[i] != remain && set.contains(remain)) {
        return true;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int remain = c - weights[i] - weights[j];
        if (weights[i] != remain && weights[j] != remain && set.contains(remain)) {
          return true;
        }
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    weights = new int[n];
    set = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
      set.add(weights[i]);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}