import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] board;

  static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

  static int answer;

  public static void main(String[] args) throws IOException {
    setUp();

    int step = 1;
    int currStepMoveCount = 0;
    int direction = 4;
    int count = 0;
    int currY = n / 2;
    int currX = n / 2;

    answer = 0;

    while (true) {
      currY += dy[direction];
      currX += dx[direction];

      if (!checkRange(currY, currX)) {
        break;
      }

      moveSand(currY, currX, direction);

      currStepMoveCount++;

      if (currStepMoveCount == step) {
        currStepMoveCount = 0;
        count++;
        direction = (direction + 6) % 8;
      }

      if (count == 2) {
        count = 0;
        step++;
      }
    }

    sb.append(answer);
    output();
  }

  private static void moveSand(int y, int x, int moveDirection) {
    int currSand = board[y][x];

    MoveInfo[] moveInfos = {
        new MoveInfo(0.1, 1, (moveDirection + 1) % 8),
        new MoveInfo(0.1, 1, (moveDirection + 7) % 8),
        new MoveInfo(0.01, 1, (moveDirection + 3) % 8),
        new MoveInfo(0.01, 1, (moveDirection + 5) % 8),
        new MoveInfo(0.07, 1, (moveDirection + 2) % 8),
        new MoveInfo(0.07, 1, (moveDirection + 6) % 8),
        new MoveInfo(0.02, 2, (moveDirection + 2) % 8),
        new MoveInfo(0.02, 2, (moveDirection + 6) % 8),
        new MoveInfo(0.05, 2, moveDirection)
    };

    int totalMovedSand = 0;

    for (MoveInfo moveInfo : moveInfos) {
      int ny = y + moveInfo.moveCount * dy[moveInfo.direction];
      int nx = x + moveInfo.moveCount * dx[moveInfo.direction];

      int sandMove = (int) Math.floor(currSand * moveInfo.percent);
      totalMovedSand += sandMove;
      if (checkRange(ny, nx)) {
        board[ny][nx] += sandMove;
      } else {
        answer += sandMove;
      }
    }

    int ny = y + dy[moveDirection];
    int nx = x + dx[moveDirection];

    int leftover = currSand - totalMovedSand;

    if (checkRange(ny, nx)) {
      board[ny][nx] += leftover;
    } else {
      answer += leftover;
    }

    board[y][x] = 0;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class MoveInfo {

    double percent;
    int moveCount, direction;

    public MoveInfo(double percent, int moveCount, int direction) {
      this.percent = percent;
      this.moveCount = moveCount;
      this.direction = direction;
    }
  }

}