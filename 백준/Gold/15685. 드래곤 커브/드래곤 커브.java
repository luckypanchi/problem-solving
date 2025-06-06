import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static final int LIMIT = 100;
  static boolean[][] board;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    board = new boolean[LIMIT + 1][LIMIT + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      draw(y, x, d, g);
    }

    int answer = 0;
    for (int y = 0; y < LIMIT; y++) {
      for (int x = 0; x < LIMIT; x++) {
        if (board[y][x] && board[y + 1][x] && board[y][x + 1] && board[y + 1][x + 1]) {
          answer++;
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void draw(int startY, int startX, int startDirection, int gen) {
    board[startY][startX] = true;

    List<Integer> directions = new ArrayList<>();
    directions.add(startDirection);
    for (int i = 0; i < gen; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = directions.size() - 1; j > -1; j--) {
        temp.add((directions.get(j) + 1) % 4);
      }
      directions.addAll(temp);
    }

    int x = startX;
    int y = startY;

    for (int d : directions) {
      x += dx[d];
      y += dy[d];
      board[y][x] = true;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}