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
  static int n, m;
  static char[][] board;
  static int[][] visited;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testCases = Integer.parseInt(br.readLine());
    while (testCases-- > 0) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      board = new char[n][m];
      visited = new int[n][m];

      for (int i = 0; i < n; i++) {
        String row = br.readLine();
        for (int j = 0; j < m; j++) {
          board[i][j] = row.charAt(j);
        }
      }

      sb.append(solve()).append("\n");
    }

    output();
  }

  private static String solve() {
    Deque<Node> startQueue = new ArrayDeque<>();
    Deque<Node> fireQueue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '@') {
          startQueue.offerLast(new Node(i, j));
          board[i][j] = '.';
          visited[i][j] = 1;
        } else if (board[i][j] == '*') {
          fireQueue.offerLast(new Node(i, j));
        }
      }
    }

    while (!startQueue.isEmpty()) {
      int fireQueueSize = fireQueue.size();
      for (int i = 0; i < fireQueueSize; i++) {
        Node fireNode = fireQueue.pollFirst();
        for (int direction = 0; direction < 4; direction++) {
          int ny = fireNode.y + dy[direction];
          int nx = fireNode.x + dx[direction];

          if (checkRange(ny, nx) && board[ny][nx] == '.') {
            board[ny][nx] = '*';
            fireQueue.offerLast(new Node(ny, nx));
          }
        }
      }

      int startSize = startQueue.size();
      for (int i = 0; i < startSize; i++) {
        Node currNode = startQueue.pollFirst();
        for (int direction = 0; direction < 4; direction++) {
          int ny = currNode.y + dy[direction];
          int nx = currNode.x + dx[direction];

          if (checkRange(ny, nx) && board[ny][nx] == '.' && visited[ny][nx] == 0) {
            visited[ny][nx] = visited[currNode.y][currNode.x] + 1;
            startQueue.offerLast(new Node(ny, nx));
          }

          if (!checkRange(ny, nx)) {
            return String.valueOf(visited[currNode.y][currNode.x]);
          }
        }
      }
    }

    return "IMPOSSIBLE";
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}