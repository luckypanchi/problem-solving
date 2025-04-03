import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, a, b;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    setUp();

    int[] visited = new int[n + 1];
    Arrays.fill(visited, -1);
    visited[a] = 0;

    Deque<Integer> que = new ArrayDeque<>();
    que.offer(a);

    while (!que.isEmpty()) {
      int curr = que.poll();

      int dist = numbers[curr];
      while (curr + dist < n + 1) {
        if (visited[curr + dist] == -1) {
          visited[curr + dist] = visited[curr] + 1;
          que.offer(curr + dist);
        }
        dist += numbers[curr];
      }

      dist = numbers[curr];
      while (0 < curr - dist) {
        if (visited[curr - dist] == -1) {
          visited[curr - dist] = visited[curr] + 1;
          que.offer(curr - dist);
        }
        dist += numbers[curr];
      }
    }

    sb.append(visited[b]);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    numbers = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}