import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[][] costs;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    costs = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(costs[i], n + 1);
      costs[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      costs[u][v] = 0;
      costs[v][u] = b == 1 ? 0 : 1;
    }

    for (int k = 1; k < n + 1; k++) {
      for (int start = 1; start < n + 1; start++) {
        for (int dest = 1; dest < n + 1; dest++) {
          if (start == dest) {
            continue;
          }

          if (costs[start][k] + costs[k][dest] < costs[start][dest]) {
            costs[start][dest] = costs[start][k] + costs[k][dest];
          }
        }
      }
    }

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int dest = Integer.parseInt(st.nextToken());
      sb.append(costs[start][dest]).append("\n");
    }

    output();
  }


  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}