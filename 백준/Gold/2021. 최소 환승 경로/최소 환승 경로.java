import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static List<List<Integer>> lines;
  static List<List<Integer>> stations;
  static int start, dest;
  static boolean[] lineVisited;
  static boolean[] stationVisited;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve());

    output();
  }

  private static int solve() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    stationVisited[start] = true;
    for (int connectedLine : stations.get(start)) {
      pq.add(new Node(connectedLine, start, 0));
      lineVisited[connectedLine] = true;
    }

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (curr.station == dest) {
        return curr.count;
      }

      for (int nextStation : lines.get(curr.line)) {
        if (stationVisited[nextStation]) {
          continue;
        }

        stationVisited[nextStation] = true;
        pq.offer(new Node(curr.line, nextStation, curr.count));

        for (int nextLine : stations.get(nextStation)) {
          if (lineVisited[nextLine]) {
            continue;
          }

          lineVisited[nextLine] = true;
          pq.offer(new Node(nextLine, nextStation, curr.count + 1));
        }
      }
    }

    return -1;
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    lines = new ArrayList<>();
    stations = new ArrayList<>();
    lineVisited = new boolean[m + 1];
    stationVisited = new boolean[n + 1];
    for (int i = 0; i < n + 1; i++) {
      stations.add(new ArrayList<>());
    }
    for (int i = 0; i < m + 1; i++) {
      lines.add(new ArrayList<>());
    }
    for (int lineNumber = 1; lineNumber < m + 1; lineNumber++) {
      st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        int currStation = Integer.parseInt(st.nextToken());
        if (currStation != -1) {
          lines.get(lineNumber).add(currStation);
          stations.get(currStation).add(lineNumber);
        }
      }
    }
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    dest = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int line, station, count;

    public Node(int line, int station, int count) {
      this.line = line;
      this.station = station;
      this.count = count;
    }

    @Override
    public int compareTo(Node o) {
      return this.count - o.count;
    }
  }

}