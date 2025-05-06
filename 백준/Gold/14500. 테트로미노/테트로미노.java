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
  static int[][][] blocks = {
      {
          {0, 0}, {0, 1}, {0, 2}, {0, 3},
      },
      {
          {0, 0}, {1, 0}, {2, 0}, {3, 0},
      },
      {
          {0, 0}, {1, 0}, {0, 1}, {1, 1},
      },
      {
          {0, 0}, {1, 0}, {2, 0}, {2, 1},
      },
      {
          {0, 0}, {0, 1}, {0, 2}, {-1, 2},
      },
      {
          {0, 0}, {0, 1}, {1, 1}, {2, 1},
      },
      {
          {0, 0}, {1, 0}, {0, 1}, {0, 2},
      },
      {
          {0, 0}, {1, 0}, {1, 1}, {2, 1},
      },
      {
          {0, 0}, {0, 1}, {-1, 1}, {-1, 2},
      },
      {
          {0, 0}, {0, 1}, {0, 2}, {1, 1},
      },
      {
          {0, 0}, {0, 1}, {0, 2}, {-1, 1},
      },
      {
          {0, 0}, {1, 0}, {2, 0}, {1, 1},
      },
      {
          {0, 0}, {1, 0}, {2, 0}, {1, -1},
      },
      {
          {0, 0}, {1, 0}, {2, 0}, {2, -1},
      },
      {
          {0, 0}, {-1, 0}, {0, 1}, {0, 2},
      },
      {
          {0, 0}, {0, 1}, {1, 0}, {2, 0},
      },
      {
          {0, 0}, {0, 1}, {0, 2}, {1, 2},
      },
      {
          {0, 0}, {1, 0}, {1, -1}, {2, -1},
      },
      {
          {0, 0}, {0, -1}, {1, 0}, {1, 1},
      }
  };

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = -1;

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        answer = Math.max(answer, getCurrMax(y, x));
      }
    }

    sb.append(answer);

    output();
  }

  private static int getCurrMax(int y, int x) {
    int result = -1;

    for (int i = 0; i < blocks.length; i++) {
      result = Math.max(result, getSum(y, x, i));
    }

    return result;
  }

  private static int getSum(int y, int x, int blockIndex) {
    int[][] block = blocks[blockIndex];
    int curr = 0;
    for (int j = 0; j < 4; j++) {
      int ny = y + block[j][0];
      int nx = x + block[j][1];

      if (!checkRange(ny, nx)) {
        return -1;
      }

      curr += board[ny][nx];
    }

    return curr;
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }


  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][m];
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