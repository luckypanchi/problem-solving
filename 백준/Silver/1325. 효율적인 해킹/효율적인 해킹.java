import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      matrix.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      matrix.get(b).add(a);
    }

    ArrayList<Integer> results = new ArrayList<>();
    int max_cnt = Integer.MIN_VALUE;

    for (int i = 1; i < n + 1; i++) {
      boolean[] visited = new boolean[n + 1];
      Deque<Integer> que = new LinkedList<>();
      que.offer(i);
      visited[i] = true;
      int cnt = 0;

      while (!que.isEmpty()) {
        int curr = que.pollFirst();
        for (int nxt : matrix.get(curr)) {
          if (!visited[nxt]) {
            cnt++;
            que.offer(nxt);
            visited[nxt] = true;
          }
        }
      }

      if (max_cnt < cnt) {
        max_cnt = cnt;
        results = new ArrayList<>();
        results.add(i);
      } else if (max_cnt == cnt) {
        results.add(i);
      }
    }

    for (int r : results) {
      System.out.print(r + " ");
    }
  }
}
