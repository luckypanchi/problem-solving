import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  static int m, n;
  static int[][] picture;
  static boolean[][] visited;
  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};

  public int[] solution(int m, int n, int[][] picture) {
    this.m = m;
    this.n = n;
    this.picture = picture;

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] != 0 && !visited[i][j]) {
          numberOfArea++;
          int count = markBfs(i, j, picture[i][j]);
          maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
        }
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  private int markBfs(int y, int x, int areaNumber) {
    int count = 1;

    Deque<Node> que = new ArrayDeque<>();
    que.offer(new Node(y, x));
    visited[y][x] = true;

    while (!que.isEmpty()) {
      Node node = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];
        if (0 <= ny && ny < m && 0 <= nx && nx < n && !visited[ny][nx] && picture[ny][nx] == areaNumber) {
          visited[ny][nx] = true;
          count++;
          que.offer(new Node(ny, nx));
        }
      }
    }

    return count;
  }

  private class Node {

    int y;
    int x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}