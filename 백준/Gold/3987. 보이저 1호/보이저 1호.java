import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static char[][] board;
  static int startY, startX;
  static boolean[][][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static final String directions = "URDL";
  static final int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    setUp();

    int answerDirection = -1;
    int maxTime = 0;

    for (int i = 0; i < 4; i++) {
      int timeCost = move(i);
      if (maxTime < timeCost) {
        answerDirection = i;
        maxTime = timeCost;
      }
    }

    String answer = maxTime == MAX ? "Voyager" : String.valueOf(maxTime);

    sb.append(directions.charAt(answerDirection)).append("\n").append(answer);
    output();
  }

  private static int move(int startDirection) {
    int currY = startY - 1;
    int currX = startX - 1;
    int d = startDirection;
    int time = 0;

    visited = new boolean[n][m][4];
    visited[currY][currX][d] = true;

    while (true) {
      time++;
      currY += dy[d];
      currX += dx[d];

      if (!check(currY, currX)) {
        break;
      }

      if (visited[currY][currX][d]) {
        return MAX;
      }

      visited[currY][currX][d] = true;

      d = turn(currY, currX, d);
    }

    return time;
  }

  private static int turn(int currY, int currX, int d) {
    if (board[currY][currX] == '/') {
      if (d == 0) {
        return 1;
      }
      if (d == 1) {
        return 0;
      }
      if (d == 2) {
        return 3;
      }
      if (d == 3) {
        return 2;
      }
    }

    if (board[currY][currX] == '\\') {
      if (d == 0) {
        return 3;
      }
      if (d == 1) {
        return 2;
      }
      if (d == 2) {
        return 1;
      }
      if (d == 3) {
        return 0;
      }
    }

    return d;
  }

  private static boolean check(int currY, int currX) {
    if (!checkRange(currY, currX)) {
      return false;
    }

    return board[currY][currX] != 'C';
  }

  private static boolean checkRange(int currY, int currX) {
    return 0 <= currY && currY < n && 0 <= currX && currX < m;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }
    st = new StringTokenizer(br.readLine());
    startY = Integer.parseInt(st.nextToken());
    startX = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}