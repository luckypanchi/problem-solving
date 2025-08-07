import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static PriorityQueue<Building> pq;
  static TreeMap<Integer, Integer> treeMap;

  public static void main(String[] args) throws IOException {
    setUp();

    int maxX = 0;
    int maxHeight = 0;

    treeMap.put(0, 1);

    while (!pq.isEmpty()) {
      Building building = pq.poll();

      if (building.h > 0) {
        treeMap.put(building.h, treeMap.getOrDefault(building.h, 0) + 1);
      } else {
        int value = treeMap.get(-building.h);
        if (value == 1) {
          treeMap.remove(-building.h);
        } else {
          treeMap.put(-building.h, value - 1);
        }
      }

      int currMaxHeight = treeMap.firstKey();
      if (maxX != building.x && maxHeight != currMaxHeight) {
        maxX = building.x;
        maxHeight = currMaxHeight;
        sb.append(maxX + " " + maxHeight + " ");
      }
    }

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>((o1, o2) -> {
      if (o1.x != o2.x) {
        return o1.x - o2.x;
      }
      return o2.h - o1.h;
    });
    treeMap = new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      pq.add(new Building(s, h));
      pq.add(new Building(e, -h));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Building {

    int x, h;

    public Building(int x, int h) {
      this.x = x;
      this.h = h;
    }
  }

}