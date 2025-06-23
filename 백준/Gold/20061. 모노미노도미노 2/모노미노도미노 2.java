import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[][] blueBoard;
  static int[][] greenBoard;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    blueBoard = new int[4][6];
    greenBoard = new int[6][4];
    answer = 0;

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      processGreenBoard(t, y, x);
      processBlueBoard(t, y, x);
    }

    sb.append(answer).append("\n");
    sb.append(countGreenBoard() + countBlueBoard());

    output();
  }

  private static void processGreenBoard(int t, int y, int x) {
    // 1. 놓기
    // 2. 내리기
    putOnGreenBoard(t, y, x);

    // 3. 가득 찬 행 없는 지 확인
    // 4. 있다면 없애고 점수 획득
    // 5. 없앤 만큼 내리기
    while (true) {
      int rowNumber = checkFullRows();
      if (rowNumber == -1) {
        break;
      }
      deleteFullRows(rowNumber);
      answer++;
      moveDown(rowNumber);
    }

    // 6. 연한 색 칸에 있는지 확인
    // 7. 없앤 만큼 내리기
    int count = checkTopRows();
    for (int i = 0; i < count; i++) {
      moveDown(5);
    }
  }

  private static void processBlueBoard(int t, int y, int x) {
    putOnBlueBoard(t, y, x);

    while (true) {
      int colNumber = checkFullCols();
      if (colNumber == -1) {
        break;
      }
      deleteFullCols(colNumber);
      answer++;
      moveRight(colNumber);
    }

    int count = checkLeftCols();
    for (int i = 0; i < count; i++) {
      moveRight(5);
    }
  }

  private static void putOnBlueBoard(int t, int y, int x) {
    if (t == 1) {
      boolean flag = false;
      for (int nx = 1; nx < 6; nx++) {
        if (blueBoard[y][nx] != 0) {
          blueBoard[y][nx - 1] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        blueBoard[y][5] = 1;
      }
    } else if (t == 2) {
      boolean flag = false;
      for (int nx = 2; nx < 6; nx++) {
        if (blueBoard[y][nx] != 0) {
          blueBoard[y][nx - 1] = 1;
          blueBoard[y][nx - 2] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        blueBoard[y][5] = 1;
        blueBoard[y][4] = 1;
      }
    } else if (t == 3) {
      boolean flag = false;
      for (int nx = 1; nx < 6; nx++) {
        if (blueBoard[y][nx] != 0 || blueBoard[y + 1][nx] != 0) {
          blueBoard[y][nx - 1] = 1;
          blueBoard[y + 1][nx - 1] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        blueBoard[y][5] = 1;
        blueBoard[y + 1][5] = 1;
      }
    }
  }

  private static int checkFullCols() {
    for (int x = 2; x < 6; x++) {
      int sum = 0;
      for (int y = 0; y < 4; y++) {
        sum += blueBoard[y][x];
      }
      if (sum == 4) {
        return x;
      }
    }

    return -1;
  }

  private static void deleteFullCols(int colNumber) {
    for (int y = 0; y < 4; y++) {
      blueBoard[y][colNumber] = 0;
    }
  }

  private static void moveRight(int colNumber) {
    for (int x = colNumber; x > 0; x--) {
      for (int y = 0; y < 4; y++) {
        blueBoard[y][x] = blueBoard[y][x - 1];
      }
    }
    for (int y = 0; y < 4; y++) {
      blueBoard[y][0] = 0;
    }
  }

  private static int checkLeftCols() {
    int count = 0;
    for (int x = 0; x < 2; x++) {
      for (int y = 0; y < 4; y++) {
        if (blueBoard[y][x] != 0) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  private static void putOnGreenBoard(int t, int y, int x) {
    if (t == 1) {
      boolean flag = false;
      for (int ny = 1; ny < 6; ny++) {
        if (greenBoard[ny][x] != 0) {
          greenBoard[ny - 1][x] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        greenBoard[5][x] = 1;
      }
    } else if (t == 2) {
      boolean flag = false;
      for (int ny = 1; ny < 6; ny++) {
        if (greenBoard[ny][x] != 0 || greenBoard[ny][x + 1] != 0) {
          greenBoard[ny - 1][x] = 1;
          greenBoard[ny - 1][x + 1] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        greenBoard[5][x] = 1;
        greenBoard[5][x + 1] = 1;
      }
    } else if (t == 3) {
      boolean flag = false;
      for (int ny = 2; ny < 6; ny++) {
        if (greenBoard[ny][x] != 0) {
          greenBoard[ny - 1][x] = 1;
          greenBoard[ny - 2][x] = 1;
          flag = true;
          break;
        }
      }
      if (!flag) {
        greenBoard[5][x] = 1;
        greenBoard[4][x] = 1;
      }
    }
  }

  private static int checkFullRows() {
    for (int y = 2; y < 6; y++) {
      int sum = 0;
      for (int x = 0; x < 4; x++) {
        sum += greenBoard[y][x];
      }
      if (sum == 4) {
        return y;
      }
    }

    return -1;
  }

  private static void deleteFullRows(int rowNumber) {
    for (int x = 0; x < 4; x++) {
      greenBoard[rowNumber][x] = 0;
    }
  }

  private static void moveDown(int rowNumber) {
    for (int y = rowNumber; y > 0; y--) {
      for (int x = 0; x < 4; x++) {
        greenBoard[y][x] = greenBoard[y - 1][x];
      }
    }
    for (int x = 0; x < 4; x++) {
      greenBoard[0][x] = 0;
    }
  }

  private static int checkTopRows() {
    int count = 0;
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 4; x++) {
        if (greenBoard[y][x] != 0) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  private static int countGreenBoard() {
    int count = 0;
    for (int y = 2; y < 6; y++) {
      for (int x = 0; x < 4; x++) {
        count += greenBoard[y][x];
      }
    }
    return count;
  }

  private static int countBlueBoard() {
    int count = 0;
    for (int x = 2; x < 6; x++) {
      for (int y = 0; y < 4; y++) {
        count += blueBoard[y][x];
      }
    }
    return count;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}