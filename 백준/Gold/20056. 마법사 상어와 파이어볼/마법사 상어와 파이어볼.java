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
  static int n, m, k;

  static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  static List<List<List<Fireball>>> board;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < k; i++) {
      moveFireballs();
      combineFireballs();
    }

    int answer = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        for (Fireball fireball : board.get(y).get(x)) {
          answer += fireball.m;
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void combineFireballs() {
    List<List<List<Fireball>>> dest = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dest.add(new ArrayList<>());
      for (int j = 0; j < n; j++) {
        dest.get(i).add(new ArrayList<>());
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board.get(y).get(x).size() == 0) {
          continue;
        }
        if (board.get(y).get(x).size() == 1) {
          dest.get(y).get(x).add(board.get(y).get(x).get(0));
          continue;
        }

        int mSum = 0;
        int sSum = 0;
        for (Fireball fireball : board.get(y).get(x)) {
          mSum += fireball.m;
          sSum += fireball.s;
        }

        int newM = mSum / 5;
        int newS = sSum / board.get(y).get(x).size();
        boolean isAllEvenOrOdd = isAllEvenOrOdd(board.get(y).get(x));

        if (newM == 0) {
          continue;
        }

        for (int i = 0; i < 8; i++) {
          if (isAllEvenOrOdd && i % 2 == 0) {
            dest.get(y).get(x).add(new Fireball(newM, newS, i));
          } else if (!isAllEvenOrOdd && i % 2 != 0) {
            dest.get(y).get(x).add(new Fireball(newM, newS, i));
          }
        }
      }
    }

    board = dest;
  }

  private static boolean isAllEvenOrOdd(List<Fireball> fireballs) {
    boolean isEven = fireballs.get(0).d % 2 == 0;

    for (Fireball fireball : fireballs) {
      if (isEven && fireball.d % 2 == 0) {
        continue;
      } else if (!isEven && fireball.d % 2 != 0) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  private static void moveFireballs() {
    List<List<List<Fireball>>> dest = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dest.add(new ArrayList<>());
      for (int j = 0; j < n; j++) {
        dest.get(i).add(new ArrayList<>());
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        for (Fireball fireball : board.get(y).get(x)) {
          int ny = (y + fireball.s * (dy[fireball.d] + n)) % n;
          int nx = (x + fireball.s * (dx[fireball.d] + n)) % n;
          dest.get(ny).get(nx).add(fireball);
        }
      }
    }

    board = dest;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      board.add(new ArrayList<>());
      for (int j = 0; j < n; j++) {
        board.get(i).add(new ArrayList<>());
      }
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int m = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      board.get(r).get(c).add(new Fireball(m, s, d));
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Fireball {

    int m, s, d;

    public Fireball(int m, int s, int d) {
      this.m = m;
      this.s = s;
      this.d = d;
    }
  }
}