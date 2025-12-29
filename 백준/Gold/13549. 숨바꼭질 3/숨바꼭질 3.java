import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  int pos;
  int count;

  public Node(int pos, int count) {
    this.pos = pos;
    this.count = count;
  }
}

public class Main {

  static int n, k;
  static boolean[] visited;
  static final int MAX = 100001;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    visited = new boolean[MAX];
    bfs();
    System.out.println(answer);
  }

  public static void bfs() {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(n, 0));
    visited[n] = true;

    while (!que.isEmpty()) {
      Node node = que.poll();

      if (node.pos == k) answer = Math.min(answer, node.count);

      if (2 * node.pos < MAX && visited[2 * node.pos] == false) {
        visited[2 * node.pos] = true;
        que.add(new Node(2 * node.pos, node.count));
      }

      int[] nxt = { -1, 1 };
      for (int num : nxt) {
        if (
          0 <= node.pos + num &&
          node.pos + num < MAX &&
          visited[node.pos + num] == false
        ) {
          visited[node.pos + num] = true;
          que.add(new Node(node.pos + num, node.count + 1));
        }
      }
    }
  }
}
