import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[] parents;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    parents = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parents[i] = i;
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a, b);
    }

    int answer = 0;
    st = new StringTokenizer(br.readLine());
    int curr = find(Integer.parseInt(st.nextToken()));
    for (int i = 1; i < n; i++) {
      int next = Integer.parseInt(st.nextToken());
      if (curr != find(next)) {
        curr = find(next);
        answer++;
      }
    }

    sb.append(answer);
    output();
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static boolean union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) {
      return false;
    }

    if (a < b) {
      parents[b] = a;
    } else {
      parents[a] = b;
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