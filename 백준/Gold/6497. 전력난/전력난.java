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
  static int m, n, totalCost;
  static List<Edge> edges;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      totalCost = 0;

      if (m == 0 && n == 0) {
        break;
      }

      edges = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        totalCost += c;
        edges.add(new Edge(a, b, c));
      }

      parents = new int[m];
      for (int i = 0; i < m; i++) {
        parents[i] = i;
      }

      Collections.sort(edges);

      int cost = 0;
      for (Edge e : edges) {
        if (union(e.city1, e.city2)) {
          cost += e.cost;
        }
      }

      sb.append(totalCost - cost).append("\n");
    }

    output();
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static boolean union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) {
      return false;
    }

    if (a < b) {
      parents[b] = a;
    } else if (b < a) {
      parents[a] = b;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Edge implements Comparable<Edge> {

    int city1;
    int city2;
    int cost;

    public Edge(int city1, int city2, int cost) {
      this.city1 = city1;
      this.city2 = city2;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
      return this.cost - other.cost;
    }
  }

}