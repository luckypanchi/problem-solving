import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }

  @Override
  public int compareTo(Node node) {
    if (this.x == node.x) {
      return this.y - node.y;
    } else {
      return this.x - node.x;
    }
  }
}

public class Main {

  static int[][] matrix;
  static boolean[][] visited;
  static int[] dx = { 1, 0, 1, -1 };
  static int[] dy = { 0, 1, 1, 1 };
  static ArrayList<Node> record;

  static int winner;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    matrix = new int[19][19];

    for (int i = 0; i < 19; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 19; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Loop:for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (matrix[i][j] != 0) {
          if (go(i, j, matrix[i][j])) {
            winner = matrix[i][j];
            break Loop;
          }
        }
      }
    }

    if (winner == 0) {
      System.out.println("0");
    } else {
      Collections.sort(record);
      Node node = record.get(0);
      sb
        .append(winner)
        .append("\n")
        .append(node.y + 1)
        .append(" ")
        .append(node.x + 1);
      System.out.println(sb);
    }
  }

  static boolean go(int y, int x, int color) {
    visited = new boolean[19][19];
    visited[y][x] = true;
    Node node = new Node(y, x);
    for (int i = 0; i < 4; i++) {
      record = new ArrayList<>();
      record.add(node);
      check(node, color, dy[i], dx[i]);
      check(node, color, -dy[i], -dx[i]);
      if (record.size() == 5) {
        return true;
      }
    }
    return false;
  }

  static void check(Node node, int color, int dirY, int dirX) {
    int ny = node.y + dirY;
    int nx = node.x + dirX;

    if (
      0 <= ny &&
      ny < 19 &&
      0 <= nx &&
      nx < 19 &&
      matrix[ny][nx] == color &&
      visited[ny][nx] == false
    ) {
      visited[ny][nx] = true;
      Node newNode = new Node(ny, nx);
      record.add(newNode);
      check(newNode, color, dirY, dirX);
    }
  }
}
