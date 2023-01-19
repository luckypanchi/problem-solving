import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int r, c, n;
  static int[][] bombs;
  static int time = 1;

  static int[] dy = { 0, 0, 1, 0, -1 };
  static int[] dx = { 0, 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    bombs = new int[r][c];

    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
        char input = row.charAt(j);
        if (input == 'O') {
          bombs[i][j] = 3;
        }
      }
    }

    int nextStep = 0;

    while (time < n) {
      time++;

      if (nextStep == 0) {
        putBombs();
        nextStep = 1;
      } else {
        explode();
        nextStep = 0;
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (bombs[i][j] != 0) {
          sb.append("O");
        } else {
          sb.append(".");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static void putBombs() {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (bombs[i][j] == 0) {
          bombs[i][j] = time + 3;
        }
      }
    }
  }

  static void explode() {
    int[][] candidates = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (bombs[i][j] == time) {
          for (int k = 0; k < 5; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (0 <= ny && ny < r && 0 <= nx && nx < c) {
              candidates[ny][nx] = 1;
            }
          }
        }
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (candidates[i][j] == 1) {
          bombs[i][j] = 0;
        }
      }
    }
  }
}
