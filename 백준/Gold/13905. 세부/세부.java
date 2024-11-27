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
  static int n, m;
  static int[] parents;
  static List<Edge> edgeList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    edgeList = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      parents[i] = i;
    }
    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      edgeList.add(new Edge(a, b, c));
    }

    edgeList.sort((e1, e2) -> e2.weight - e1.weight);

    sb.append(kruskal(s, e));

    output();
  }

  private static int kruskal(int s, int e) {
    for (Edge edge : edgeList) {
      union(edge.start, edge.end);
      if (find(s) == find(e)) {
        return edge.weight;
      }
    }
    return 0;
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return false;
    }

    if (x < y) {
      parents[y] = x;
    } else {
      parents[x] = y;
    }
    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Edge {

    int start, end, weight;

    public Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }
  }

}