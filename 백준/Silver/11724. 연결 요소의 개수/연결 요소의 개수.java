import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      union(u, v);
    }

    Set<Integer> countSet = new HashSet<>();
    for (int i = 1; i < n + 1; i++) {
      countSet.add(find(i));
    }
    sb.append(countSet.size());

    output();
  }

  private static void union(int u, int v) {
    u = find(u);
    v = find(v);

    if (u < v) {
      parents[v] = u;
    } else if (v < u) {
      parents[u] = v;
    }
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static void setUp() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parents[i] = i;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}