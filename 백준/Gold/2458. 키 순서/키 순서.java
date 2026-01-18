import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int c = 1; c < n + 1; c++) {
      for (int a = 1; a < n + 1; a++) {
        for (int b = 1; b < n + 1; b++) {
          if (graph[a][b] == 1 || (graph[a][c] == 1 && graph[c][b] == 1)) {
            graph[a][b] = 1;
          }
        }
      }
    }

    int answer = 0;
    for (int start = 1; start < n + 1; start++) {
      int count = 0;
      for (int end = 1; end < n + 1; end++) {
        count += graph[start][end] + graph[end][start];
      }

      if (count == n - 1) {
        answer++;
      }
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a][b] = 1;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}