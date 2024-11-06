import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Map<Integer, List<Integer>> graph;
  static int[] target;

  public static void main(String[] args) throws IOException {
    setUp();

    if (target[0] != 1 || !bfs()) {
      sb.append(0);
    } else {
      sb.append(1);
    }

    output();
  }

  private static boolean bfs() {
    boolean[] visited = new boolean[n + 1];
    Deque<Integer> que = new ArrayDeque<>();

    visited[1] = true;
    que.offer(1);

    int curr = 1;

    while (!que.isEmpty()) {
      int x = que.pollFirst();
      int childCount = 0;

      for (int y : graph.get(x)) {
        if (!visited[y]) {
          visited[y] = true;
          childCount++;
        }
      }

      for (int next = curr; next < curr + childCount; next++) {
        if (!visited[target[next]]) {
          return false;
        } else {
          que.offer(target[next]);
        }
      }
      curr += childCount;
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    target = new int[n];
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      target[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}