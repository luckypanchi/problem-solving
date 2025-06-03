import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[][] targets;
  static int k;
  static int[][] rotations;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < k; i++) {
      int targetIndex = rotations[i][0];
      int rotationDir = rotations[i][1];

      if (checkRight(targetIndex)) {
        dfs(targetIndex + 1, -rotationDir, 1);
      }

      if (checkLeft(targetIndex)) {
        dfs(targetIndex - 1, -rotationDir, -1);
      }

      rotate(targets[targetIndex], rotationDir);
    }

    int answer = 0;
    for (int i = 0; i < 4; i++) {
      if (targets[i][0] == 1) {
        answer += (int) Math.pow(2, i);
      }
    }

    sb.append(answer);
    output();
  }

  private static void dfs(int curr, int rotationDir, int moveDir) {
    if (curr < 0 || 4 <= curr) {
      return;
    }

    if (moveDir == 1 && checkRight(curr)) {
      dfs(curr + 1, -rotationDir, 1);
    } else if (moveDir == -1 && checkLeft(curr)) {
      dfs(curr - 1, -rotationDir, -1);
    }

    rotate(targets[curr], rotationDir);
  }

  private static boolean checkRight(int currIndex) {
    return currIndex + 1 < 4 && targets[currIndex][2] != targets[currIndex + 1][6];
  }

  private static boolean checkLeft(int currIndex) {
    return 0 <= currIndex - 1 && targets[currIndex][6] != targets[currIndex - 1][2];
  }

  private static void rotate(int[] target, int rotationDir) {
    if (rotationDir == 1) {
      rotateClockwise(target);
    } else if (rotationDir == -1) {
      rotateCounterClockwise(target);
    }
  }

  private static void rotateClockwise(int[] target) {
    int temp = target[target.length - 1];
    for (int i = target.length - 1; i > 0; i--) {
      target[i] = target[i - 1];
    }
    target[0] = temp;
  }

  private static void rotateCounterClockwise(int[] target) {
    int temp = target[0];
    for (int i = 0; i < target.length - 1; i++) {
      target[i] = target[i + 1];
    }
    target[target.length - 1] = temp;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    targets = new int[4][8];
    for (int i = 0; i < 4; i++) {
      String row = br.readLine();
      for (int j = 0; j < 8; j++) {
        targets[i][j] = row.charAt(j) - '0';
      }
    }
    k = Integer.parseInt(br.readLine());
    rotations = new int[k][2];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      rotations[i][0] = Integer.parseInt(st.nextToken()) - 1;
      rotations[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}