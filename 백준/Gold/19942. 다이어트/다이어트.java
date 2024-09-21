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
  static int n, mp, mf, ms, mv, minCost;
  static int[][] nutrients;
  static List<Integer> selected;
  static List<String> allCombinations;

  public static void main(String[] args) throws IOException {
    setUp();

    minCost = Integer.MAX_VALUE;
    selected = new ArrayList<>();
    subset(0, 0, 0, 0, 0, 0);

    if (minCost == Integer.MAX_VALUE) {
      sb.append(-1);
    } else {
      sb.append(minCost).append("\n");
      Collections.sort(allCombinations);
      sb.append(allCombinations.get(0));
    }

    output();
  }

  private static void subset(int curr, int prevProtein, int prevFat, int preCarbo, int prevVitamin, int prevCost) {
    if (curr == n) {
      if (mp <= prevProtein && mf <= prevFat && ms <= preCarbo && mv <= prevVitamin) {
        if (prevCost < minCost) {
          minCost = prevCost;
          allCombinations.clear();
          allCombinations.add(createCombString());
        } else if (prevCost == minCost) {
          allCombinations.add(createCombString());
        }
      }
      return;
    }

    selected.add(curr + 1);
    subset(curr + 1, prevProtein + nutrients[curr][0], prevFat + nutrients[curr][1], preCarbo + nutrients[curr][2],
        prevVitamin + nutrients[curr][3], prevCost + nutrients[curr][4]);
    selected.remove(selected.size() - 1);

    subset(curr + 1, prevProtein, prevFat, preCarbo, prevVitamin, prevCost);
  }

  private static String createCombString() {
    StringBuilder currComb = new StringBuilder();
    for (int num : selected) {
      currComb.append(num).append(" ");
    }
    return currComb.toString();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    mp = Integer.parseInt(st.nextToken());
    mf = Integer.parseInt(st.nextToken());
    ms = Integer.parseInt(st.nextToken());
    mv = Integer.parseInt(st.nextToken());
    nutrients = new int[n][5];
    allCombinations = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        nutrients[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}