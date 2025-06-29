import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[][] sharkBoard;
  static Smell[][] smellBoard;
  static int[][][] priorities;

  static Shark[] sharks;

  static int currTime;

  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    currTime = 0;

    leaveSmell();
    while (check() && currTime <= 1000) {
      currTime++;
      solve();
    }

    if (1000 < currTime) {
      sb.append(-1);
    } else {
      sb.append(currTime);
    }

    output();
  }

  private static boolean check() {
    for (int sharkNumber = 2; sharkNumber < m + 1; sharkNumber++) {
      if (sharks[sharkNumber] != null) {
        return true;
      }
    }
    return false;
  }

  private static void solve() {
    moveSharks();
    removeSmell();
    leaveSmell();
  }

  private static void moveSharks() {
    int[][] newSharkBoard = new int[n][n];

    for (int sharkNumber = 1; sharkNumber < m + 1; sharkNumber++) {
      if (sharks[sharkNumber] == null) {
        continue;
      }

      Shark dest = move(sharkNumber);
      if (newSharkBoard[dest.y][dest.x] != 0) {
        sharks[sharkNumber] = null;
        continue;
      }

      newSharkBoard[dest.y][dest.x] = sharkNumber;
      sharks[sharkNumber] = dest;
    }

    sharkBoard = newSharkBoard;
  }

  private static Shark move(int sharkNumber) {
    Shark shark = sharks[sharkNumber];
    int[] directions = priorities[sharkNumber][shark.direction];
    for (int d : directions) {
      int ny = shark.y + dy[d];
      int nx = shark.x + dx[d];
      if (checkRange(ny, nx) && smellBoard[ny][nx] == null) {
        return new Shark(ny, nx, d);
      }
    }

    for (int d : directions) {
      int ny = shark.y + dy[d];
      int nx = shark.x + dx[d];
      if (checkRange(ny, nx) && smellBoard[ny][nx].sharkNumber == sharkNumber) {
        return new Shark(ny, nx, d);
      }
    }

    return null;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void leaveSmell() {
    for (int sharkNumber = 1; sharkNumber < m + 1; sharkNumber++) {
      if (sharks[sharkNumber] == null) {
        continue;
      }

      Shark shark = sharks[sharkNumber];
      smellBoard[shark.y][shark.x] = new Smell(shark.y, shark.x, sharkNumber, currTime + k);
    }
  }

  private static void removeSmell() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (smellBoard[i][j] == null) {
          continue;
        }

        if (smellBoard[i][j].endTime == currTime) {
          smellBoard[i][j] = null;
        }
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    sharkBoard = new int[n][n];
    sharks = new Shark[m + 1];
    smellBoard = new Smell[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int sharkNumber = Integer.parseInt(st.nextToken());
        if (sharkNumber == 0) {
          continue;
        }

        sharkBoard[i][j] = sharkNumber;
        sharks[sharkNumber] = new Shark(i, j);
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < m + 1; i++) {
      sharks[i].direction = Integer.parseInt(st.nextToken()) - 1;
    }

    priorities = new int[m + 1][4][4];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 0; j < 4; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < 4; k++) {
          priorities[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
        }
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Shark {

    int y, x, direction;

    public Shark(int y, int x) {
      this.y = y;
      this.x = x;
    }

    public Shark(int y, int x, int direction) {
      this.y = y;
      this.x = x;
      this.direction = direction;
    }
  }

  private static class Smell {

    int y, x, sharkNumber, endTime;

    public Smell(int y, int x, int sharkNumber, int endTime) {
      this.y = y;
      this.x = x;
      this.sharkNumber = sharkNumber;
      this.endTime = endTime;
    }
  }

}