import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r, c, k;
  static int[][] board;
  static int rowLength, colLength;

  public static void main(String[] args) throws IOException {
    setUp();

    int time = 0;
    while (time < 100) {
      if (board[r - 1][c - 1] == k) {
        break;
      }

      if (rowLength >= colLength) {
        operationR();
      } else {
        operationC();
      }

      time++;
    }

    if (board[r - 1][c - 1] == k) {
      sb.append(time);
    } else {
      sb.append(-1);
    }
    output();
  }

  private static void operationC() {
    int[][] newBoard = new int[100][100];
    int newRowLength = -1;

    for (int j = 0; j < colLength; j++) {
      Map<Integer, Integer> counter = new HashMap<>();
      for (int i = 0; i < rowLength; i++) {
        if (board[i][j] == 0) {
          continue;
        }
        counter.put(board[i][j], counter.getOrDefault(board[i][j], 0) + 1);
      }

      List<Pair> pairList = getSortedPairList(counter);

      int currRowLength = Math.min(2 * pairList.size(), 100);
      newRowLength = Math.max(newRowLength, currRowLength);
      for (int i = 0; i < currRowLength; i += 2) {
        Pair pair = pairList.get(i / 2);
        newBoard[i][j] = pair.number;
        newBoard[i + 1][j] = pair.count;
      }
    }

    board = newBoard;
    rowLength = newRowLength;
  }

  private static void operationR() {
    int[][] newBoard = new int[100][100];
    int newColLength = -1;
    for (int i = 0; i < rowLength; i++) {
      Map<Integer, Integer> counter = new HashMap<>();
      for (int j = 0; j < colLength; j++) {
        if (board[i][j] == 0) {
          continue;
        }
        counter.put(board[i][j], counter.getOrDefault(board[i][j], 0) + 1);
      }

      List<Pair> pairList = getSortedPairList(counter);

      int currColLength = Math.min(2 * pairList.size(), 100);
      newColLength = Math.max(newColLength, currColLength);
      for (int j = 0; j < currColLength; j += 2) {
        Pair pair = pairList.get(j / 2);
        newBoard[i][j] = pair.number;
        newBoard[i][j + 1] = pair.count;
      }
    }

    board = newBoard;
    colLength = newColLength;
  }

  private static List<Pair> getSortedPairList(Map<Integer, Integer> counter) {
    List<Pair> pairList = new ArrayList<>();
    for (int key : counter.keySet()) {
      pairList.add(new Pair(key, counter.get(key)));
    }
    pairList.sort((o1, o2) -> {
      if (o1.count == o2.count) {
        return o1.number - o2.number;
      }
      return o1.count - o2.count;
    });
    return pairList;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    board = new int[100][100];
    rowLength = 3;
    colLength = 3;
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
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

  private static class Pair {

    int number, count;

    public Pair(int number, int count) {
      this.number = number;
      this.count = count;
    }
  }

}