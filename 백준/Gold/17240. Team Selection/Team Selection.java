import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, answer;
  static int[][] stats;
  static Player[][] players;
  static boolean[] isRoleSelected;
  static boolean[] isPlayerSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < 5; i++) {
      Arrays.sort(players[i]);
    }

    answer = Integer.MIN_VALUE;
    solve(0, 0);

    sb.append(answer);
    output();
  }

  private static void solve(int depth, int prevSum) {
    if (depth == 5) {
      answer = Math.max(answer, prevSum);
      return;
    }

    for (int i = 0; i < 5; i++) {
      if (isRoleSelected[i]) {
        continue;
      }

      isRoleSelected[i] = true;
      for (int j = 0; j < n; j++) {
        Player player = players[i][j];
        if (isPlayerSelected[player.index]) {
          continue;
        }

        isPlayerSelected[player.index] = true;
        solve(depth + 1, prevSum + player.stat);
        isPlayerSelected[player.index] = false;
        break;
      }
      isRoleSelected[i] = false;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    stats = new int[n][5];
    players = new Player[5][n];
    isRoleSelected = new boolean[5];
    isPlayerSelected = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        stats[i][j] = Integer.parseInt(st.nextToken());
        players[j][i] = new Player(i, stats[i][j]);
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Player implements Comparable<Player> {

    int index;
    int stat;

    public Player(int index, int stat) {
      this.index = index;
      this.stat = stat;
    }

    @Override
    public int compareTo(Player o) {
      return o.stat - this.stat;
    }
  }

}