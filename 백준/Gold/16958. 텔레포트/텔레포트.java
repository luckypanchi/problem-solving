import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, t;
  static int[][] cities;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    cities = new int[n + 1][3];
    for (int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        cities[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dists = new int[n + 1][n + 1];
    for (int i = 1; i < n + 1; i++) {
      Arrays.fill(dists[i], Integer.MAX_VALUE);
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (i == j) {
          dists[i][i] = 0;
        } else {
          int d = calcDist(i, j);
          dists[i][j] = d;
          dists[j][i] = d;
        }
      }
    }

    for (int k = 1; k < n + 1; k++) {
      for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
        }
      }
    }

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append(dists[a][b]).append("\n");
    }

    output();
  }

  private static int calcDist(int city1, int city2) {
    int d = Math.abs(cities[city1][1] - cities[city2][1]) + Math.abs(cities[city1][2] - cities[city2][2]);
    if (cities[city1][0] == 1 && cities[city2][0] == 1) {
      return Math.min(t, d);
    }
    return d;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}