import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;
  static int currY, currX;
  static int currDir;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;

    while (true) {

      if (board[currY][currX] == 0) {
        board[currY][currX] = -1;
        answer++;
      }

      if (!checkUncleaned(currY, currX)) {
        int d = (currDir + 2) % 4;
        int ny = currY + dy[d];
        int nx = currX + dx[d];
        if (board[ny][nx] != 1) {
          currY = ny;
          currX = nx;
        } else {
          break;
        }
      } else {
        currDir = (currDir + 3) % 4;
        int ny = currY + dy[currDir];
        int nx = currX + dx[currDir];
        if (board[ny][nx] == 0) {
          currY = ny;
          currX = nx;
        }
      }

    }

    sb.append(answer);
    output();
  }

  private static boolean checkUncleaned(int y, int x) {
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (board[ny][nx] == 0) {
        return true;
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    st = new StringTokenizer(br.readLine());
    currY = Integer.parseInt(st.nextToken());
    currX = Integer.parseInt(st.nextToken());
    currDir = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
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

}