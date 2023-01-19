import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  int stair;
  int count;

  public Node(int stair, int count) {
    this.stair = stair;
    this.count = count;
  }
}

public class Main {

  static int f, s, g, u, d;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    f = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    visited = new boolean[f + 1];
    bfs();
  }

  public static void bfs() {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(s, 0));
    visited[s] = true;

    while (!que.isEmpty()) {
      Node node = que.poll();

      if (node.stair == g) {
        System.out.println(node.count);
        return;
      }

      if (node.stair + u <= f && visited[node.stair + u] == false) {
        que.add(new Node(node.stair + u, node.count + 1));
        visited[node.stair + u] = true;
      }
      if (1 <= node.stair - d && visited[node.stair - d] == false) {
        que.add(new Node(node.stair - d, node.count + 1));
        visited[node.stair - d] = true;
      }
    }
    System.out.println("use the stairs");
  }
}
