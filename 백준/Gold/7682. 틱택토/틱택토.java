import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static List<String> games;

  public static void main(String[] args) throws IOException {
    setUp();

    for (String game : games) {
      boolean result = solve(game);
      sb.append(result ? "valid" : "invalid").append("\n");
    }

    output();
  }

  private static boolean solve(String game) {
    int oCount = 0;
    int xCount = 0;
    int blankCount = 0;
    for (int i = 0; i < 9; i++) {
      if (game.charAt(i) == 'O') {
        oCount++;
      } else if (game.charAt(i) == 'X') {
        xCount++;
      } else if (game.charAt(i) == '.') {
        blankCount++;
      }
    }

    if (xCount != oCount + 1 && xCount != oCount) {
      return false;
    }

    boolean isOWin = checkWinnable(game, 'O');
    boolean isXWin = checkWinnable(game, 'X');

    /**
     * 가득 차지 않은 상태로 끝났다면, 둘 중 하나는 승리해야 한다.
     */
    if (blankCount != 0 && !isOWin && !isXWin) {
      return false;
    }

    /**
     * 둘 중 하나만 승리를 해야 한다.
     */
    if (isOWin && isXWin) {
      return false;
    }

    /**
     * 선공인 X의 승리로 끝났다면, X의 개수는 O의 개수보다 하나 더 많아야 한다.
     */
    if (!isOWin && isXWin) {
      return xCount == oCount + 1;
    }

    /**
     * 후공인 O의 승리로 끝났다면, X의 개수와 O의 개수가 동일해야 한다.
     */
    if (isOWin && !isXWin) {
      return xCount == oCount;
    }

    return true;
  }

  private static boolean checkWinnable(String game, char target) {
    boolean result1 = checkRows(game, target);
    boolean result2 = checkCols(game, target);
    boolean result3 = checkDaegak(game, target);

    if (result1 && !result2 && !result3) {
      return true;
    }

    if (!result1 && result2 && !result3) {
      return true;
    }

    if (!result1 && !result2 && result3) {
      return true;
    }

    return false;
  }

  private static boolean checkDaegak(String game, char target) {
    int result = 0;
    if (game.charAt(0) == target && game.charAt(4) == target && game.charAt(8) == target) {
      result++;
    }

    if (game.charAt(2) == target && game.charAt(4) == target && game.charAt(6) == target) {
      result++;
    }

    return result == 1;
  }

  private static boolean checkCols(String game, char target) {
    int result = 0;
    if (game.charAt(0) == target && game.charAt(3) == target && game.charAt(6) == target) {
      result++;
    }

    if (game.charAt(1) == target && game.charAt(4) == target && game.charAt(7) == target) {
      result++;
    }

    if (game.charAt(2) == target && game.charAt(5) == target && game.charAt(8) == target) {
      result++;
    }

    return result == 1;
  }

  private static boolean checkRows(String game, char target) {
    int result = 0;
    if (game.charAt(0) == target && game.charAt(1) == target && game.charAt(2) == target) {
      result++;
    }

    if (game.charAt(3) == target && game.charAt(4) == target && game.charAt(5) == target) {
      result++;
    }

    if (game.charAt(6) == target && game.charAt(7) == target && game.charAt(8) == target) {
      result++;
    }

    return result == 1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    games = new ArrayList<>();
    while (true) {
      String game = br.readLine();
      if (game.equals("end")) {
        break;
      }
      games.add(game);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}