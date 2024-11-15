import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] start;
  static Map<Integer, List<int[]>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(dijkstra());

    output();
  }

  private static int dijkstra() {
    Map<String, Integer> distances = new HashMap<>();
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1, o2) -> o1.cost - o2.cost);

    distances.put(arrToStr(start), 0);
    pq.offer(new Pair(start, 0));

    int answer = Integer.MAX_VALUE;

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();

      if (check(curr.array)) {
        answer = Math.min(answer, curr.cost);
      }

      if (distances.get(arrToStr(curr.array)) < curr.cost) {
        continue;
      }

      for (int i = 0; i < curr.array.length; i++) {
        for (int[] next : graph.get(i)) {
          int targetIndex = next[0];
          int totalCost = curr.cost + next[1];
          int[] nextArray = swap(curr.array, i, targetIndex);
          if (!distances.containsKey(arrToStr(nextArray)) || totalCost < distances.get(arrToStr(nextArray))) {
            distances.put(arrToStr(nextArray), totalCost);
            pq.offer(new Pair(nextArray, totalCost));
          }
        }
      }
    }

    return answer != Integer.MAX_VALUE ? answer : -1;
  }

  private static boolean check(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return false;
      }
    }
    return true;
  }

  private static int[] swap(int[] array, int index1, int index2) {
    int[] ret = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      ret[i] = array[i];
    }

    int tmp = ret[index1];
    ret[index1] = ret[index2];
    ret[index2] = tmp;

    return ret;
  }

  private static String arrToStr(int[] target) {
    StringBuilder ret = new StringBuilder();
    for (int num : target) {
      ret.append(num);
    }
    return ret.toString();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    start = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      start[i] = Integer.parseInt(st.nextToken());
    }
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int[] array;
    int cost;

    public Pair(int[] array, int cost) {
      this.array = array;
      this.cost = cost;
    }
  }

}