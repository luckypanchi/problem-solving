import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, q;
  static int[] parents;
  static List<Trunk> trunkList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    trunkList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      st.nextToken();
      parents[i + 1] = i + 1;
      trunkList.add(new Trunk(i + 1, x1, x2));
    }

    trunkList.sort((o1, o2) -> o1.x1 - o2.x1);

    for (int i = 0; i < n; i++) {
      Trunk curr = trunkList.get(i);
      for (int j = i + 1; j < n; j++) {
        Trunk next = trunkList.get(j);
        if (next.x1 <= curr.x2) {
          union(curr.number, next.number);
        } else {
          break;
        }
      }
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int target1 = Integer.parseInt(st.nextToken());
      int target2 = Integer.parseInt(st.nextToken());
      if (find(target1) == find(target2)) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }

    output();
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

  private static class Trunk {

    int number, x1, x2;

    public Trunk(int number, int x1, int x2) {
      this.number = number;
      this.x1 = x1;
      this.x2 = x2;
    }
  }

}