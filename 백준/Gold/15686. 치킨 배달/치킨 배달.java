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
  static int n, m, answer;
  static List<int[]> houses, chickens;
  static int[][] board;
  static int[] selected;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = Integer.MAX_VALUE;
    selected = new int[m];
    combination(0, 0);

    sb.append(answer);
    output();
  }

  private static void combination(int curr, int start) {
    if (curr == m) {
      answer = Math.min(answer, calcChickenDist());
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      selected[curr] = i;
      combination(curr + 1, i + 1);
    }
  }

  private static int calcChickenDist() {
    int result = 0;
    for (int[] house : houses) {
      int minDist = Integer.MAX_VALUE;
      for (int selectedChickenIndex : selected) {
        int[] selectedChicken = chickens.get(selectedChickenIndex);
        int dist = Math.abs(house[0] - selectedChicken[0]) + Math.abs(house[1] - selectedChicken[1]);
        minDist = Math.min(minDist, dist);
      }
      result += minDist;
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    houses = new ArrayList<>();
    chickens = new ArrayList<>();
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 1) {
          houses.add(new int[]{i, j});
        } else if (board[i][j] == 2) {
          chickens.add(new int[]{i, j});
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