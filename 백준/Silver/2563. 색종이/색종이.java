import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] papers, board;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int[] paper : papers) {
      for (int x = paper[0]; x < paper[0] + 10; x++) {
        for (int y = paper[1]; y < paper[1] + 10; y++) {
          board[x][y] = 1;
        }
      }
    }

    int answer = 0;
    for (int x = 0; x < 101; x++) {
      for (int y = 0; y < 101; y++) {
        answer += board[x][y];
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    papers = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      papers[i][0] = Integer.parseInt(st.nextToken());
      papers[i][1] = Integer.parseInt(st.nextToken());
    }

    board = new int[101][101];

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}