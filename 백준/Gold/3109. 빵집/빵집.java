import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r, c, answer;
  static char[][] board;
  static boolean[][] visited;
  static int[] dy = {-1, 0, 1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < r; i++) {
      dfs(i, 0);
    }

    sb.append(answer);

    output();
  }

  private static boolean dfs(int y, int x) {
    if (x == c - 1) {
      answer++;
      return true;
    }

    for (int i = 0; i < 3; i++) {
      int ny = y + dy[i];
      if (0 <= ny && ny < r && !visited[ny][x + 1] && board[ny][x + 1] == '.') {
        visited[ny][x + 1] = true;
        if (dfs(ny, x + 1)) {
          return true;
        }
      }
    }

    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    board = new char[r][c];
    for (int i = 0; i < r; i++) {
      String line = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    visited = new boolean[r][c];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}