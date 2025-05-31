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
  static int n, k, l;
  static int[][] board;
  static Deque<Info> infoList;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    Deque<Node> snake = new ArrayDeque<>();
    snake.offer(new Node(0, 0));
    board[0][0] = -1;
    int currDir = 0;
    int currTime = 0;

    int headY = 0;
    int headX = 0;

    while (!snake.isEmpty()) {

      int ny = headY + dy[currDir];
      int nx = headX + dx[currDir];

      if (!checkRange(ny, nx) || board[ny][nx] == -1) {
        currTime++;
        break;
      }

      if (board[ny][nx] != 1) {
        Node prev = snake.pollFirst();
        board[prev.y][prev.x] = 0;
      }

      headY = ny;
      headX = nx;
      board[headY][headX] = -1;
      snake.offer(new Node(headY, headX));

      currTime++;

      if (!infoList.isEmpty()) {
        Info info = infoList.peekFirst();
        if (info.time == currTime) {
          infoList.pollFirst();
          if (info.dir.equals("L")) {
            currDir = (currDir + 3) % 4;
          } else if (info.dir.equals("D")) {
            currDir = (currDir + 1) % 4;
          }
        }
      }

    }

    sb.append(currTime);
    output();
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      board[y][x] = 1;
    }
    l = Integer.parseInt(br.readLine());
    infoList = new ArrayDeque<>();
    for (int i = 0; i < l; i++) {
      st = new StringTokenizer(br.readLine());
      infoList.offer(new Info(Integer.parseInt(st.nextToken()), st.nextToken()));
    }
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

  private static class Info {

    int time;
    String dir;

    public Info(int time, String dir) {
      this.time = time;
      this.dir = dir;
    }
  }

}