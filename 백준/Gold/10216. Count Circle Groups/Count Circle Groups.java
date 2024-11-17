import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static List<Pair> camps;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      n = Integer.parseInt(br.readLine());
      camps = new ArrayList<>();
      parents = new int[n];
      for (int i = 0; i < n; i++) {
        parents[i] = i;
      }

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        camps.add(new Pair(x, y, r));
      }

      for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (check(i, j)) {
            union(i, j);
          }
        }
      }

      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        set.add(find(i));
      }

      sb.append(set.size()).append("\n");
    }

    output();
  }

  private static boolean check(int index1, int index2) {
    Pair camp1 = camps.get(index1);
    Pair camp2 = camps.get(index2);
    return Math.pow(camp1.x - camp2.x, 2) + Math.pow(camp1.y - camp2.y, 2) <= Math.pow(camp1.r + camp2.r, 2);
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
    } else {
      parents[x] = y;
    }

    return true;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int x, y, r;

    public Pair(int x, int y, int r) {
      this.x = x;
      this.y = y;
      this.r = r;
    }
  }

}