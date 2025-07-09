import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Map<Integer, Set<Integer>> friends;
  static int[] orders;
  static int[][] board;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int curr : orders) {
      Set<Integer> currFriends = friends.get(curr);
      int maxFriendCount = 0;
      int maxBlankCount = 0;
      Node seat = new Node(n - 1, n - 1);

      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {

          if (board[y][x] != 0) {
            continue;
          }

          int friendCount = 0;
          int blankCount = 0;

          for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (!checkRange(ny, nx)) {
              continue;
            }

            if (board[ny][nx] == 0) {
              blankCount++;
            } else if (currFriends.contains(board[ny][nx])) {
              friendCount++;
            }
          }

          if (maxFriendCount < friendCount) {
            maxFriendCount = friendCount;
            maxBlankCount = blankCount;
            seat = new Node(y, x);
            continue;
          }

          if (friendCount < maxFriendCount) {
            continue;
          }

          if (maxBlankCount < blankCount) {
            maxBlankCount = blankCount;
            seat = new Node(y, x);
            continue;
          }

          if (blankCount < maxBlankCount) {
            continue;
          }

          if (y < seat.y || (y == seat.y && x < seat.x)) {
            seat = new Node(y, x);
          }
        }
      }

      board[seat.y][seat.x] = curr;
    }

    int answer = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {

        int curr = board[y][x];
        Set<Integer> currFriends = friends.get(curr);
        int count = 0;

        for (int i = 0; i < 4; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];

          if (!checkRange(ny, nx)) {
            continue;
          }

          if (currFriends.contains(board[ny][nx])) {
            count++;
          }
        }

        if (count != 0) {
          answer += (int) Math.pow(10, count - 1);
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    friends = new HashMap<>();
    orders = new int[n * n];
    board = new int[n][n];

    friends.put(0, new HashSet<>());
    for (int i = 0; i < n * n; i++) {
      st = new StringTokenizer(br.readLine());
      int curr = Integer.parseInt(st.nextToken());
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < 4; j++) {
        set.add(Integer.parseInt(st.nextToken()));
      }
      orders[i] = curr;
      friends.put(curr, set);
    }
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