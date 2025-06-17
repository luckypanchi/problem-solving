import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[][] colorBoard;
  static int[][][] board;
  static int n, k;
  static Horse[] horseList;

  static int[] dx = {0, 1, -1, 0, 0};
  static int[] dy = {0, 0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = -1;
    for (int t = 1; t < 1001; t++) {
      if (!moveHorses()) {
        answer = t;
        break;
      }
    }

    sb.append(answer);
    output();
  }

  private static boolean moveHorses() {
    for (int horse = 1; horse < k + 1; horse++) {
      if (!move(horse)) {
        return false;
      }
    }

    return true;
  }

  private static boolean move(int horseNumber) {
    Horse horse = horseList[horseNumber];
    int ny = horse.y + dy[horse.direction];
    int nx = horse.x + dx[horse.direction];

    if (!checkRange(ny, nx) || colorBoard[ny][nx] == 2) {
      return moveBlue(horseNumber);
    } else if (colorBoard[ny][nx] == 0) {
      return moveWhite(horseNumber);
    } else {
      return moveRed(horseNumber);
    }
  }

  private static boolean moveRed(int horseNumber) {
    Horse horse = horseList[horseNumber];
    int ny = horse.y + dy[horse.direction];
    int nx = horse.x + dx[horse.direction];

    if (4 <= getCount(ny, nx, 0) + getCount(horse.y, horse.x, horse.index)) {
      return false;
    }

    int start = 0;
    while (board[ny][nx][start] != 0) {
      start++;
    }

    int last = 2;
    while (board[horse.y][horse.x][last] == 0) {
      last--;
    }

    for (int i = horse.index; i < 3; i++) {
      if (board[horse.y][horse.x][i] == 0) {
        break;
      }
      board[ny][nx][start + i - horse.index] = board[horse.y][horse.x][last - i + horse.index];
    }

    for (int i = 0; i < 3; i++) {
      int h = board[ny][nx][i];

      if (h == 0) {
        break;
      }

      Horse curr = horseList[h];
      horseList[h] = new Horse(ny, nx, i, curr.direction);
    }

    for (int i = horse.index; i < 3; i++) {
      board[horse.y][horse.x][i] = 0;
    }

    return true;
  }

  private static boolean moveWhite(int horseNumber) {
    Horse horse = horseList[horseNumber];
    int ny = horse.y + dy[horse.direction];
    int nx = horse.x + dx[horse.direction];

    if (4 <= getCount(ny, nx, 0) + getCount(horse.y, horse.x, horse.index)) {
      return false;
    }

    int start = 0;
    while (board[ny][nx][start] != 0) {
      start++;
    }

    for (int i = horse.index; i < 3; i++) {
      if (board[horse.y][horse.x][i] == 0) {
        break;
      }
      board[ny][nx][start + i - horse.index] = board[horse.y][horse.x][i];
    }

    for (int i = 0; i < 3; i++) {
      int h = board[ny][nx][i];

      if (h == 0) {
        break;
      }

      Horse curr = horseList[h];
      horseList[h] = new Horse(ny, nx, i, curr.direction);
    }

    for (int i = horse.index; i < 3; i++) {
      board[horse.y][horse.x][i] = 0;
    }

    return true;
  }

  private static boolean moveBlue(int horseNumber) {
    Horse horse = horseList[horseNumber];
    int newDirection = turn(horse.direction);
    int ny = horse.y + dy[newDirection];
    int nx = horse.x + dx[newDirection];

    horseList[horseNumber] = new Horse(horse.y, horse.x, horse.index, newDirection);

    if (!checkRange(ny, nx) || colorBoard[ny][nx] == 2) {
      return true;
    } else if (colorBoard[ny][nx] == 0) {
      return moveWhite(horseNumber);
    } else {
      return moveRed(horseNumber);
    }
  }

  private static int getCount(int y, int x, int start) {
    int count = 0;
    for (int i = start; i < 3; i++) {
      if (board[y][x][i] != 0) {
        count++;
      } else {
        break;
      }
    }

    return count;
  }

  private static int turn(int direction) {
    if (direction == 1 || direction == 2) {
      return 3 - direction;
    } else {
      return 7 - direction;
    }
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    colorBoard = new int[n][n];
    board = new int[n][n][3];
    horseList = new Horse[k + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        colorBoard[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      int d = Integer.parseInt(st.nextToken());
      board[y][x][0] = i + 1;
      horseList[i + 1] = new Horse(y, x, 0, d);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Horse {

    int y, x, index, direction;

    public Horse(int y, int x, int index, int direction) {
      this.y = y;
      this.x = x;
      this.index = index;
      this.direction = direction;
    }
  }

}