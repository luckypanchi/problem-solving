import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] board;
  static boolean[][] visited;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    List<Integer> counts = new ArrayList<>();
    for (int startY = 0; startY < n; startY++) {
      for (int startX = 0; startX < n; startX++) {
        if (board[startY][startX] == 1 && !visited[startY][startX]) {
          answer++;
          visited[startY][startX] = true;
          counts.add(dfs(startY, startX));
        }
      }
    }

    counts.sort((o1, o2) -> o1 - o2);

    sb.append(answer).append("\n");
    for (int count : counts) {
      sb.append(count).append("\n");
    }

    output();
  }

  private static int dfs(int currY, int currX) {
    int result = 1;

    for (int i = 0; i < 4; i++) {
      int ny = currY + dy[i];
      int nx = currX + dx[i];

      if (!checkRange(ny, nx) || visited[ny][nx] || board[ny][nx] == 0) {
        continue;
      }

      visited[ny][nx] = true;
      result += dfs(ny, nx);
    }

    return result;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = row.charAt(j) - '0';
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