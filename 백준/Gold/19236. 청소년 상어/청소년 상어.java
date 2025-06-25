import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[][] initBoard;
  static Fish[] initFishList;
  static int answer;

  static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    Fish fish = initFishList[initBoard[0][0]];
    Shark shark = new Shark(0, 0, fish.direction);
    initFishList[initBoard[0][0]] = null;
    initBoard[0][0] = -1;

    solve(shark, initBoard, initFishList, fish.number);

    sb.append(answer);
    output();
  }

  private static void solve(Shark shark, int[][] prevBoard, Fish[] prevFishList, int totalSum) {
    answer = Math.max(answer, totalSum);

    int[][] board = copyBoard(prevBoard);
    Fish[] fishList = copyFishList(prevFishList);

    fishMove(fishList, board);

    int nx = shark.x + dx[shark.direction];
    int ny = shark.y + dy[shark.direction];

    while (checkRange(ny, nx)) {
      if (0 < board[ny][nx]) {
        int fishNumber = board[ny][nx];
        Fish fish = fishList[fishNumber];

        board[shark.y][shark.x] = 0;
        board[ny][nx] = -1;
        fishList[fishNumber] = null;
        Shark newShark = new Shark(ny, nx, fish.direction);
        solve(newShark, board, fishList, totalSum + fish.number);
        fishList[fishNumber] = fish;
        board[ny][nx] = fishNumber;
        board[shark.y][shark.x] = -1;
      }

      nx += dx[shark.direction];
      ny += dy[shark.direction];
    }
  }

  private static void fishMove(Fish[] fishList, int[][] board) {
    for (int fishNumber = 1; fishNumber < 17; fishNumber++) {
      Fish fish = fishList[fishNumber];
      if (fish == null) {
        continue;
      }

      int nextDirection = findNextDirection(board, fish);
      if (nextDirection == -1) {
        continue;
      }

      int ny = fish.y + dy[nextDirection];
      int nx = fish.x + dx[nextDirection];
      if (board[ny][nx] == 0) {
        fishList[fishNumber] = new Fish(ny, nx, fishNumber, nextDirection);
        board[ny][nx] = fishNumber;
        board[fish.y][fish.x] = 0;
        continue;
      }

      int targetFishNumber = board[ny][nx];
      Fish targetFish = fishList[targetFishNumber];
      board[ny][nx] = fishNumber;
      board[fish.y][fish.x] = targetFishNumber;
      fishList[fishNumber] = new Fish(ny, nx, fishNumber, nextDirection);
      fishList[targetFishNumber] = new Fish(fish.y, fish.x, targetFishNumber, targetFish.direction);
    }
  }

  private static int findNextDirection(int[][] board, Fish fish) {
    for (int i = 0; i < 8; i++) {
      int d = (fish.direction + i) % 8;
      int ny = fish.y + dy[d];
      int nx = fish.x + dx[d];
      if (!checkRange(ny, nx) || board[ny][nx] == -1) {
        continue;
      }
      return d;
    }
    return -1;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < 4 && 0 <= x && x < 4;
  }

  private static int[][] copyBoard(int[][] original) {
    int[][] dest = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        dest[i][j] = original[i][j];
      }
    }
    return dest;
  }

  private static Fish[] copyFishList(Fish[] original) {
    Fish[] dest = new Fish[17];
    for (int i = 0; i < 17; i++) {
      dest[i] = original[i];
    }
    return dest;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    initBoard = new int[4][4];
    initFishList = new Fish[17];
    answer = -1;

    for (int i = 0; i < 4; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        initFishList[a] = new Fish(i, j, a, b - 1);
        initBoard[i][j] = a;
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Fish {

    int y, x, number, direction;

    public Fish(int y, int x, int number, int direction) {
      this.y = y;
      this.x = x;
      this.number = number;
      this.direction = direction;
    }
  }

  private static class Shark {

    int y, x, direction;

    public Shark(int y, int x, int direction) {
      this.y = y;
      this.x = x;
      this.direction = direction;
    }
  }

}