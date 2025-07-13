import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static int[][] board;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  static final int EMPTY = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    while (true) {
      List<BlockGroup> blockGroups = findBlockGroups();

      if (blockGroups.isEmpty()) {
        break;
      }

      Collections.sort(blockGroups);
      BlockGroup biggest = blockGroups.get(0);

      int size = biggest.blocks.size();
      answer += size * size;
      removeBlocks(biggest.blocks);

      applyGravity();
      rotate();
      applyGravity();
    }

    sb.append(answer);
    output();
  }

  private static void rotate() {
    int[][] newBoard = new int[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        newBoard[n - 1 - x][y] = board[y][x];
      }
    }

    board = newBoard;
  }

  private static void applyGravity() {
    for (int x = 0; x < n; x++) {
      for (int y = n - 2; y > -1; y--) {
        if (board[y][x] == -1) {
          continue;
        }

        int currY = y;
        while (currY + 1 != n && board[currY + 1][x] == EMPTY) {
          board[currY + 1][x] = board[currY][x];
          board[currY][x] = EMPTY;
          currY++;
        }
      }
    }
  }

  private static void removeBlocks(List<Block> blocks) {
    for (Block block : blocks) {
      board[block.y][block.x] = EMPTY;
    }
  }

  private static List<BlockGroup> findBlockGroups() {
    List<BlockGroup> result = new ArrayList<>();

    boolean[][] visited = new boolean[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (0 < board[y][x] && board[y][x] < m + 1 && !visited[y][x]) {
          BlockGroup curr = findBlockGroup(y, x, board[y][x], visited);
          if (curr != null) {
            result.add(curr);
          }
        }
      }
    }

    return result;
  }

  private static BlockGroup findBlockGroup(int y, int x, int color, boolean[][] visited) {
    List<Block> blocks = new ArrayList<>();
    blocks.add(new Block(y, x));

    int rainbowBlockCount = 0;
    Block std = new Block(y, x);

    Deque<Block> que = new ArrayDeque<>();
    que.offer(new Block(y, x));

    visited[y][x] = true;

    boolean[][] currVisited = new boolean[n][n];
    currVisited[y][x] = true;

    while (!que.isEmpty()) {
      Block curr = que.pollFirst();

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dy[i];
        int nx = curr.x + dx[i];

        if (!checkRange(ny, nx) || currVisited[ny][nx] || (board[ny][nx] != 0 && board[ny][nx] != color)) {
          continue;
        }

        que.offer(new Block(ny, nx));
        currVisited[ny][nx] = true;
        if (board[ny][nx] == color) {
          visited[ny][nx] = true;
        }
        blocks.add(new Block(ny, nx));

        if (board[ny][nx] == color) {
          if ((ny < std.y) || (ny == std.y && nx < std.x)) {
            std = new Block(ny, nx);
          }
        } else if (board[ny][nx] == 0) {
          rainbowBlockCount++;
        }
      }
    }

    if (blocks.size() < 2) {
      return null;
    }

    return new BlockGroup(std, rainbowBlockCount, blocks);
  }

  private static boolean checkRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
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

  private static class BlockGroup implements Comparable<BlockGroup> {

    Block std;
    int rainbowBlockCount;
    List<Block> blocks;

    public BlockGroup(Block std, int rainbowBlockCount, List<Block> blocks) {
      this.std = std;
      this.rainbowBlockCount = rainbowBlockCount;
      this.blocks = blocks;
    }

    @Override
    public int compareTo(BlockGroup o) {
      if (this.blocks.size() != o.blocks.size()) {
        return o.blocks.size() - this.blocks.size();
      }

      if (this.rainbowBlockCount != o.rainbowBlockCount) {
        return o.rainbowBlockCount - this.rainbowBlockCount;
      }

      if (this.std.y != o.std.y) {
        return o.std.y - this.std.y;
      }

      return o.std.x - this.std.x;
    }
  }

  private static class Block {

    int y, x;

    public Block(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}
