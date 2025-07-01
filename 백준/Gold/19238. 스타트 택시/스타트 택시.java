import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, fuel;
  static int[][] board, startMarkBoard;
  static Node[] startPoints;
  static Node[] destPoints;
  static boolean[] visited;

  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    boolean flag = true;
    int currIndex = 0;
    for (int clientCount = 0; clientCount < m; clientCount++) {
      Result result = findClient(currIndex);
      int moveCount1 = result.cost;
      if (fuel < moveCount1 || moveCount1 == -1) {
        flag = false;
        break;
      }

      currIndex = result.nodeIndex;
      int moveCount2 = transferClient(currIndex);
      if (fuel < moveCount1 + moveCount2 || moveCount2 == -1) {
        flag = false;
        break;
      }

      fuel -= moveCount1;
      fuel += moveCount2;
      startMarkBoard[startPoints[currIndex].y][startPoints[currIndex].x] = 0;
    }

    sb.append(flag ? fuel : -1);
    output();
  }

  private static int transferClient(int nodeIndex) {
    Node startNode = startPoints[nodeIndex];
    Node destNode = destPoints[nodeIndex];

    int[][] dist = new int[n][n];
    dist[startNode.y][startNode.x] = 1;
    Deque<Node> que = new ArrayDeque<>();
    que.offer(startNode);

    while (!que.isEmpty()) {
      Node curr = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || dist[ny][nx] != 0 || board[ny][nx] == 1) {
          continue;
        }

        if (ny == destNode.y && nx == destNode.x) {
          return dist[curr.y][curr.x];
        }

        dist[ny][nx] = dist[curr.y][curr.x] + 1;
        que.offer(new Node(ny, nx));
      }
    }

    return -1;
  }

  private static Result findClient(int nodeIndex) {
    if (startMarkBoard[destPoints[nodeIndex].y][destPoints[nodeIndex].x] != 0) {
      return new Result(startMarkBoard[destPoints[nodeIndex].y][destPoints[nodeIndex].x], 0);
    }

    int[][] dist = new int[n][n];
    dist[destPoints[nodeIndex].y][destPoints[nodeIndex].x] = 1;
    Deque<Node> que = new ArrayDeque<>();
    que.offer(destPoints[nodeIndex]);

    int minDist = Integer.MAX_VALUE;
    int minIndex = -1;
    Node minNode = null;

    while (!que.isEmpty()) {
      Node curr = que.pollFirst();

      if (minDist < dist[curr.y][curr.x] - 1) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];
        int currDist = dist[curr.y][curr.x];

        if (!checkRange(ny, nx) || dist[ny][nx] != 0 || board[ny][nx] == 1) {
          continue;
        }

        if (startMarkBoard[ny][nx] != 0) {
          int index = startMarkBoard[ny][nx];
          Node node = startPoints[index];
          if (currDist < minDist) {
            minDist = currDist;
            minIndex = index;
            minNode = node;
          } else if (currDist == minDist && node.y < minNode.y) {
            minIndex = index;
            minNode = node;
          } else if (currDist == minDist && node.y == minNode.y && node.x < minNode.x) {
            minIndex = index;
            minNode = node;
          }
          continue;
        }

        dist[ny][nx] = dist[curr.y][curr.x] + 1;
        que.offer(new Node(ny, nx));
      }
    }

    minDist = minDist == Integer.MAX_VALUE ? -1 : minDist;
    return new Result(minIndex, minDist);
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    fuel = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    startMarkBoard = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    startPoints = new Node[m + 1];
    destPoints = new Node[m + 1];
    visited = new boolean[m + 1];
    st = new StringTokenizer(br.readLine());
    Node taxiStart = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
    startPoints[0] = taxiStart;
    destPoints[0] = taxiStart;
    for (int i = 1; i < m + 1; i++) {
      st = new StringTokenizer(br.readLine());
      int sy = Integer.parseInt(st.nextToken()) - 1;
      int sx = Integer.parseInt(st.nextToken()) - 1;
      int ey = Integer.parseInt(st.nextToken()) - 1;
      int ex = Integer.parseInt(st.nextToken()) - 1;
      startPoints[i] = new Node(sy, sx);
      destPoints[i] = new Node(ey, ex);
      startMarkBoard[sy][sx] = i;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Result {

    int nodeIndex, cost;

    public Result(int nodeIndex, int cost) {
      this.nodeIndex = nodeIndex;
      this.cost = cost;
    }
  }

  private static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}