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
  static int[] dy = new int[]{0, 1, 0, -1};
  static int[] dx = new int[]{1, 0, -1, 0};

  public static void main(String[] args) throws IOException {
    setUp();

    int zeroCount = 0;
    int oneCount = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 0) {
          zeroCount++;
        } else {
          oneCount++;
        }
      }
    }

    int answer = -1;
    if (zeroCount % 2 == 0 && oneCount % 2 == 0) {
      answer = solve();
    }

    sb.append(answer);

    output();
  }

  private static int solve() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < 4; k++) {
          int ny = i + dy[k];
          int nx = j + dx[k];
          if (0 <= ny && ny < n && 0 <= nx && nx < m && board[i][j] == board[ny][nx]) {
            return 1;
          }
        }
      }
    }

    return -1;
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