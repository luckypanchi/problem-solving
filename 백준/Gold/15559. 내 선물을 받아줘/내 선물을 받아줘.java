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
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int[][] visited;
  static int depth, answer;

  public static void main(String[] args) throws IOException {
    setUp();

    visited = new int[n][m];
    depth = 0;
    answer = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j] == 0) {
          depth++;
          visited[i][j] = depth;
          solve(i, j);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void solve(int currY, int currX) {
    int ny = currY + dy[board[currY][currX]];
    int nx = currX + dx[board[currY][currX]];

    if (visited[ny][nx] == 0) {
      visited[ny][nx] = depth;
      solve(ny, nx);
    } else if (visited[ny][nx] == depth) {
      answer++;
    }
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = convert(line.charAt(j));
      }
    }
  }

  private static int convert(char ch) {
    if (ch == 'N') {
      return 3;
    }
    if (ch == 'S') {
      return 1;
    }
    if (ch == 'E') {
      return 0;
    }
    if (ch == 'W') {
      return 2;
    }
    return -1;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}