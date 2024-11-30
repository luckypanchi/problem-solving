import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] parents, counts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    counts = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      parents[i] = i;
      counts[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int o = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      if (o == 1) {
        union(p, q);
      } else if (o == 2) {
        fight(p, q);
      }
    }

    List<Integer> countList = new ArrayList<>();
    for (int i = 1; i < n + 1; i++) {
      if (counts[i] != 0) {
        countList.add(counts[i]);
      }
    }

    Collections.sort(countList);

    sb.append(countList.size()).append("\n");
    for (int c : countList) {
      sb.append(c).append(" ");
    }

    output();
  }


  private static void fight(int x, int y) {
    x = find(x);
    y = find(y);

    if (counts[x] == counts[y]) {
      counts[x] = 0;
      counts[y] = 0;
      parents[x] = 0;
      parents[y] = 0;
    } else if (counts[x] < counts[y]) {
      counts[y] -= counts[x];
      parents[x] = y;
      counts[x] = 0;
    } else {
      counts[x] -= counts[y];
      parents[y] = x;
      counts[y] = 0;
    }
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return false;
    }

    if (x < y) {
      parents[y] = x;
      counts[x] += counts[y];
      counts[y] = 0;
    } else {
      parents[x] = y;
      counts[y] += counts[x];
      counts[x] = 0;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}