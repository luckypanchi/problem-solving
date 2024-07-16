import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[] parents;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int oper = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (oper == 0) {
        union(a, b);
      } else if (oper == 1) {
        if (find(a) == find(b)) {
          sb.append("YES");
        } else {
          sb.append("NO");
        }
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a < b) {
      parents[b] = a;
    } else if (b < a) {
      parents[a] = b;
    }
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
}