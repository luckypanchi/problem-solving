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
  static int n, m, answer, wallCount;
  static int[][] board;
  static List<int[]> cctvs;
  static int[][][][] directions = new int[][][][]{
      {{{}}},
      {
          {{0, 1}}, {{1, 0}}, {{0, -1}}, {{-1, 0}}
      },
      {
          {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}
      },
      {
          {{0, 1}, {1, 0}}, {{1, 0}, {0, -1}}, {{0, -1}, {-1, 0}}, {{-1, 0}, {0, 1}}
      },
      {
          {{0, 1}, {1, 0}, {0, -1}}, {{1, 0}, {0, -1}, {-1, 0}}, {{0, -1}, {-1, 0}, {0, 1}}, {{-1, 0}, {0, 1}, {1, 0}}
      },
      {
          {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
      }
  };

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    solve(0, wallCount + cctvs.size());

    sb.append(answer);
    output();
  }

  private static void solve(int curr, int prevMarkCount) {
    if (curr == cctvs.size()) {
      answer = Math.min(answer, n * m - prevMarkCount);
      return;
    }

    int[] currCctv = cctvs.get(curr);
    int type = board[currCctv[0]][currCctv[1]];
    for (int i = 0; i < directions[type].length; i++) {
      List<int[]> marked = mark(currCctv, directions[type][i]);
      solve(curr + 1, prevMarkCount + marked.size());
      unmark(marked);
    }
  }

  private static void unmark(List<int[]> marked) {
    for (int[] p : marked) {
      board[p[0]][p[1]] = 0;
    }
  }

  private static List<int[]> mark(int[] currCctv, int[][] dirs) {
    List<int[]> marked = new ArrayList<>();
    for (int[] d : dirs) {
      int ny = currCctv[0] + d[0];
      int nx = currCctv[1] + d[1];
      while (0 <= ny && ny < n && 0 <= nx && nx < m && board[ny][nx] != 6) {
        if (board[ny][nx] == 0) {
          board[ny][nx] = -1;
          marked.add(new int[]{ny, nx});
        }
        ny += d[0];
        nx += d[1];
      }
    }
    return marked;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
    cctvs = new ArrayList<>();
    wallCount = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (0 < board[i][j] && board[i][j] < 6) {
          cctvs.add(new int[]{i, j});
        } else if (board[i][j] == 6) {
          wallCount++;
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

}