import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;
  static List<Node> virusList;
  static int[] selected;
  static int answer;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    combination(0, 0);

    if (answer == Integer.MAX_VALUE) {
      answer = -1;
    }

    sb.append(answer);
    output();
  }

  private static void combination(int curr, int start) {
    if (curr == m) {
      bfs();
      return;
    }

    for (int i = start; i < virusList.size(); i++) {
      selected[curr] = i;
      combination(curr + 1, i + 1);
    }
  }

  private static void bfs() {
    Deque<Node> que = new ArrayDeque<>();
    int[][] visited = new int[n][n];
    int result = 0;

    for (int i = 0; i < m; i++) {
      Node start = virusList.get(selected[i]);
      que.offer(start);
      visited[start.y][start.x] = 1;
    }

    while (!que.isEmpty()) {
      Node curr = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];
        if (!checkRange(ny, nx) || board[ny][nx] == 1 || visited[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = visited[curr.y][curr.x] + 1;
        que.offer(new Node(ny, nx));

        if (board[ny][nx] == 0) {
          result = Math.max(result, visited[ny][nx] - 1);
        }
      }
    }

    boolean flag = true;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board[y][x] == 0 && visited[y][x] == 0) {
          flag = false;
        }
      }
    }

    if (flag) {
      answer = Math.min(answer, result);
    }
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y & y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    virusList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 2) {
          virusList.add(new Node(i, j));
        }
      }
    }

    selected = new int[virusList.size()];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}