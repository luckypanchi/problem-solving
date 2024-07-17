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
  static int n, m, k;
  static int[] parents, prices;

  public static void main(String[] args) throws IOException {
    setUp();

    Set<Integer> visited = new HashSet<>();
    int totalCost = 0;
    for (int i = 1; i < n + 1; i++) {
      int p = find(i);
      if (!visited.contains(p)) {
        visited.add(p);
        totalCost += prices[p];
      }
    }

    if (totalCost <= k) {
      sb.append(totalCost);
    } else {
      sb.append("Oh no");
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    prices = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parents[i] = i;
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      prices[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      union(u, v);
    }
  }

  private static void union(int u, int v) {
    u = find(u);
    v = find(v);

    if (u == v) {
      return;
    }

    if (prices[u] < prices[v]) {
      parents[v] = u;
    } else {
      parents[u] = v;
    }
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}