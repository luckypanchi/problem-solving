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
  static int n, q;
  static int[][] board;
  static int[] sizes;

  static int[] dx = {1, 0};
  static int[] dy = {0, 1};

  static int[] ddx = {1, 0, -1, 0};
  static int[] ddy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < q; i++) {
      int size = pow(sizes[i]);
      rotateAll(size);
      countNearIce();
    }

    int sum = 0;
    for (int y = 0; y < pow(n); y++) {
      for (int x = 0; x < pow(n); x++) {
        sum += board[y][x];
      }
    }

    sb.append(sum).append("\n").append(findBiggestIce());
    output();
  }

  private static int findBiggestIce() {
    boolean[][] visited = new boolean[pow(n)][pow(n)];

    int result = 0;
    for (int i = 0; i < pow(n); i++) {
      for (int j = 0; j < pow(n); j++) {
        if (0 < board[i][j] && !visited[i][j]) {
          result = Math.max(result, getSize(i, j, visited));
        }
      }
    }

    return result;
  }

  private static int getSize(int startY, int startX, boolean[][] visited) {
    visited[startY][startX] = true;
    Deque<Node> que = new ArrayDeque<>();
    que.offer(new Node(startY, startX));

    int size = 0;

    while (!que.isEmpty()) {
      Node curr = que.poll();

      size++;

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + ddy[i];
        int nx = curr.x + ddx[i];

        if (!checkRange(ny, nx) || visited[ny][nx] || board[ny][nx] == 0) {
          continue;
        }

        visited[ny][nx] = true;
        que.offer(new Node(ny, nx));
      }
    }

    return size;
  }

  private static void countNearIce() {

    int[][] count = new int[pow(n)][pow(n)];
    for (int y = 0; y < pow(n); y++) {
      for (int x = 0; x < pow(n); x++) {
        for (int i = 0; i < 2; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];

          if (!checkRange(ny, nx)) {
            continue;
          }

          if (board[ny][nx] > 0) {
            count[y][x]++;
          }

          if (board[y][x] > 0) {
            count[ny][nx]++;
          }
        }
      }
    }

    for (int y = 0; y < pow(n); y++) {
      for (int x = 0; x < pow(n); x++) {
        if (count[y][x] < 3 && board[y][x] > 0) {
          board[y][x]--;
        }
      }
    }
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < pow(n) && 0 <= x && x < pow(n);
  }

  private static void rotateAll(int size) {
    for (int startY = 0; startY < pow(n); startY += size) {
      for (int startX = 0; startX < pow(n); startX += size) {
        rotate(startY, startX, size);
      }
    }
  }

  private static void rotate(int startY, int startX, int length) {
    while (0 < length) {

      Deque<Integer> deque = new ArrayDeque<>();

      for (int x = startX; x < startX + length - 1; x++) {
        deque.offer(board[startY][x]);
      }

      for (int y = startY; y < startY + length - 1; y++) {
        deque.offer(board[y][startX + length - 1]);
      }

      for (int x = startX + length - 1; x > startX; x--) {
        deque.offer(board[startY + length - 1][x]);
      }

      for (int y = startY + length - 1; y > startY; y--) {
        deque.offer(board[y][startX]);
      }

      for (int i = 0; i < length - 1; i++) {
        deque.offerFirst(deque.pollLast());
      }

      for (int x = startX; x < startX + length - 1; x++) {
        board[startY][x] = deque.poll();
      }

      for (int y = startY; y < startY + length - 1; y++) {
        board[y][startX + length - 1] = deque.poll();
      }

      for (int x = startX + length - 1; x > startX; x--) {
        board[startY + length - 1][x] = deque.poll();
      }

      for (int y = startY + length - 1; y > startY; y--) {
        board[y][startX] = deque.poll();
      }

      startY++;
      startX++;
      length -= 2;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    board = new int[pow(n)][pow(n)];
    for (int i = 0; i < pow(n); i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < pow(n); j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    sizes = new int[q];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < q; i++) {
      sizes[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static int pow(int size) {
    return (int) Math.pow(2, size);
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