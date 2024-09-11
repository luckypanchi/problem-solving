import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static char[] signs;
  static int[] selected;
  static boolean[] isSelected;
  static List<String> results;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < 10; i++) {
      isSelected[i] = true;
      selected[0] = i;
      solve(0);
      isSelected[i] = false;
    }

    sb.append(Collections.max(results)).append("\n").append(Collections.min(results));

    output();
  }

  private static void solve(int curr) {
    if (curr == n) {
      String ret = "";
      for (int num : selected) {
        ret += num;
      }
      results.add(ret);
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (isSelected[i]) {
        continue;
      }

      int prev = selected[curr];
      if ((signs[curr] == '<' && prev < i) || (signs[curr] == '>' && prev > i)) {
        isSelected[i] = true;
        selected[curr + 1] = i;
        solve(curr + 1);
        isSelected[i] = false;
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    signs = new char[n];
    for (int i = 0; i < n; i++) {
      signs[i] = st.nextToken().charAt(0);
    }
    selected = new int[n + 1];
    isSelected = new boolean[10];
    results = new ArrayList<>();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}