import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static double startX, startY, destX, destY;
  static int n;
  static double[][] canons;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dijkstra());

    output();
  }

  private static double dijkstra() {
    double[] distances = new double[n];
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));

    for (int i = 0; i < n; i++) {
      double dist = calcDist(startX, startY, canons[i][0], canons[i][1]);
      distances[i] = dist / 5;
      pq.offer(new Pair(i, distances[i]));
    }

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (distances[curr.nodeNumber] < curr.cost || curr.nodeNumber == n - 1) {
        continue;
      }

      double currX = canons[curr.nodeNumber][0];
      double currY = canons[curr.nodeNumber][1];

      for (int i = 0; i < n; i++) {
        if (i == curr.nodeNumber) {
          continue;
        }

        double nextX = canons[i][0];
        double nextY = canons[i][1];
        double dist = calcDist(currX, currY, nextX, nextY);
        double totalCost = Math.min(dist / 5, Math.abs(dist - 50) / 5 + 2) + curr.cost;
        if (totalCost < distances[i]) {
          distances[i] = totalCost;
          pq.offer(new Pair(i, totalCost));
        }
      }
    }

    return distances[n - 1];
  }

  private static double calcDist(double startX, double startY, double destX, double destY) {
    return Math.sqrt(Math.pow(startX - destX, 2) + Math.pow(startY - destY, 2));
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    startX = Double.parseDouble(st.nextToken());
    startY = Double.parseDouble(st.nextToken());
    st = new StringTokenizer(br.readLine());
    destX = Double.parseDouble(st.nextToken());
    destY = Double.parseDouble(st.nextToken());
    n = Integer.parseInt(br.readLine()) + 1;
    canons = new double[n][2];
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      canons[i][0] = Double.parseDouble(st.nextToken());
      canons[i][1] = Double.parseDouble(st.nextToken());
    }
    canons[n - 1][0] = destX;
    canons[n - 1][1] = destY;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int nodeNumber;
    double cost;

    public Pair(int nodeNumber, double cost) {
      this.nodeNumber = nodeNumber;
      this.cost = cost;
    }
  }

}