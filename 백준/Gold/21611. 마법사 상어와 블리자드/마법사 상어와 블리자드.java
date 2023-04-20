import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[] convertDir = { 0, 3, 1, 0, 2 };

  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { -1, 0, 1, 0 };

  static int n, m;
  static int[][] matrix;
  static List<Integer> marbles;
  static int[][] magics;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    matrix = new int[n][n];
    magics = new int[m][2];
    marbles = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      magics[i][0] = convertDir[Integer.parseInt(st.nextToken())];
      magics[i][1] = Integer.parseInt(st.nextToken());
    }

    getMarbles();
    for (int i = 0; i < m; i++) {
      blizzard(magics[i][0], magics[i][1]);
      boolean flag = true;
      while (flag) {
        int[] results = bomb();
        for (int j = 1; j < 4; j++) answer += j * results[j];
        if (Arrays.stream(results).sum() == 0) flag = false;
      }
      change();
    }
    System.out.println(answer);
  }

  static void getMarbles() {
    int y = n / 2;
    int x = n / 2;
    int depth = 0;

    while (true) {
      for (int i = 0; i < 4; i++) {
        if (i % 2 == 0) depth++;
        for (int j = 0; j < depth; j++) {
          marbles.add(matrix[y][x]);
          y += dy[i];
          x += dx[i];
          if (x == -1 && y == 0) {
            return;
          }
        }
      }
    }
  }

  static void flush() {
    List<Integer> newMarbles = new ArrayList<>();
    newMarbles.add(0);
    for (int m : marbles) {
      if (m != 0) {
        newMarbles.add(m);
      }
    }
    while (newMarbles.size() != n * n) {
      newMarbles.add(0);
    }
    marbles = newMarbles;
  }

  static void blizzard(int d, int s) {
    int idx = 0;
    int diff = 2 * d + 1;
    for (int i = 0; i < s; i++) {
      idx += diff;
      marbles.set(idx, 0);
      diff += 8;
    }
    flush();
  }

  static int[] bomb() {
    int curr = marbles.get(1);
    int cnt = 1;
    int[] results = { 0, 0, 0, 0 };
    for (int i = 2; i < n * n; i++) {
      if (curr == marbles.get(i)) cnt++; else {
        if (cnt >= 4) {
          results[curr] += cnt;
          for (int j = i - 1; j > i - 1 - cnt; j--) {
            marbles.set(j, 0);
          }
        }
        curr = marbles.get(i);
        cnt = 1;
      }
    }
    flush();
    return results;
  }

  static void change() {
    List<Integer> newMarbles = new ArrayList<>();
    newMarbles.add(0);

    int curr = marbles.get(1);
    int cnt = 1;
    for (int i = 2; i < n * n; i++) {
      if (curr == marbles.get(i)) cnt++; else {
        if (newMarbles.size() < n * n) newMarbles.add(cnt);
        if (newMarbles.size() < n * n) newMarbles.add(curr);
        curr = marbles.get(i);
        cnt = 1;
      }
    }
    while (newMarbles.size() != n * n) {
      newMarbles.add(0);
    }
    marbles = newMarbles;
  }
}
