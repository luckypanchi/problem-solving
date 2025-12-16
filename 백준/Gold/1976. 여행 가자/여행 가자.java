import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] parents;
  static int[] travel;

  public static void main(String[] args) throws IOException {
    setUp();

    int parent = find(travel[0]);
    boolean answer = true;

    for (int i = 1; i < m; i++) {
      if (parent != find(travel[i])) {
        answer = false;
        break;
      }
    }

    sb.append(answer ? "YES" : "NO");
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    parents = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
      parents[i] = i;
    }

    for (int i = 1; i < n + 1; i++) {

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < n + 1; j++) {
        int flag = Integer.parseInt(st.nextToken());

        if (flag == 1) {
          union(i, j);
        }
      }
    }
    travel = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      travel[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static int find(int x) {
    if (parents[x] == x) {
      return x;
    }

    return find(parents[x]);
  }

  private static void union(int a, int b) {
    int parentA = find(a);
    int parentB = find(b);

    if (parentA < parentB) {
      parents[parentB] = parentA;
    } else if (parentA > parentB) {
      parents[parentA] = parentB;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}