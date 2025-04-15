import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Map<Integer, List<Pair>> graph;

  public static void main(String[] args) throws IOException {
    setUp();

    long[] visited = new long[n + 1];
    Arrays.fill(visited, -1);
    visited[1] = 0;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(1);

    while (!que.isEmpty()) {
      int cur = que.poll();

      for (Pair pair : graph.get(cur)) {
        if (visited[pair.dest] == -1) {
          visited[pair.dest] = visited[cur] + pair.weight;
          que.offer(pair.dest);
        }
      }
    }

    long answer = -1;
    for (int i = 1; i < n + 1; i++) {
      answer = Math.max(answer, visited[i]);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    graph = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Pair(b, c));
      graph.get(b).add(new Pair(a, c));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int dest;
    int weight;

    public Pair(int dest, int weight) {
      this.dest = dest;
      this.weight = weight;
    }
  }

}