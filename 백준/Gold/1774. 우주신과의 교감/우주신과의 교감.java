import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] points;
  static int[][] connected;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    setUp();

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        pq.add(new Edge(i, j, calcDist(i, j)));
      }
    }

    double answer = 0;
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      if (union(edge.point1, edge.point2)) {
        answer += edge.weight;
      }
    }

    sb.append(String.format("%.2f", answer));
    output();
  }

  private static double calcDist(int a, int b) {
    int x1 = points[a][0];
    int y1 = points[a][1];
    int x2 = points[b][0];
    int y2 = points[b][1];
    return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
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

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    points = new int[n][2];
    connected = new int[m][2];

    parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      points[i][0] = Integer.parseInt(st.nextToken());
      points[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      connected[i][0] = Integer.parseInt(st.nextToken()) - 1;
      connected[i][1] = Integer.parseInt(st.nextToken()) - 1;
      union(connected[i][0], connected[i][1]);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Edge implements Comparable<Edge> {

    int point1, point2;
    double weight;

    public Edge(int point1, int point2, double weight) {
      this.point1 = point1;
      this.point2 = point2;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      if (this.weight < o.weight) {
        return -1;
      }
      return 1;
    }
  }
}