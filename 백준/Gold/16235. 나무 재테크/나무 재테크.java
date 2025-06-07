import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, k;
  static int[][] add;
  static int[][] food;
  static int[][] dead;
  static List<List<List<Integer>>> tree;

  static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < k; i++) {
      spring();
      summer();
      fall();
      winter();
    }

    int answer = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        answer += tree.get(y).get(x).size();
      }
    }

    sb.append(answer);
    output();
  }

  private static void winter() {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        food[y][x] += add[y][x];
      }
    }
  }

  private static void fall() {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        List<Integer> currBlock = tree.get(y).get(x);
        for (int currTree : currBlock) {
          if (currTree % 5 != 0) {
            continue;
          }

          for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (checkRange(ny, nx)) {
              tree.get(ny).get(nx).add(1);
            }
          }
        }
      }
    }
  }

  private static void summer() {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        food[y][x] += dead[y][x];
      }
    }
  }

  private static void spring() {
    dead = new int[n][n];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        List<Integer> currBlock = tree.get(y).get(x);
        List<Integer> newBlock = new ArrayList<>();
        Collections.sort(currBlock);
        for (int currTree : currBlock) {
          if (currTree <= food[y][x]) {
            food[y][x] -= currTree;
            newBlock.add(currTree + 1);
          } else {
            dead[y][x] += currTree / 2;
          }
        }
        tree.get(y).set(x, newBlock);
      }
    }
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    add = new int[n][n];
    food = new int[n][n];
    tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        add[i][j] = Integer.parseInt(st.nextToken());
        food[i][j] = 5;
      }
    }

    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
      for (int j = 0; j < n; j++) {
        tree.get(i).add(new ArrayList<>());
      }
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int z = Integer.parseInt(st.nextToken());
      tree.get(x).get(y).add(z);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}