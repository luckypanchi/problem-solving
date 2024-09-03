import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] correct;
  static int[] minkyu;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(0);
    sb.append(answer);

    output();
  }

  /**
   * 기준점이 될 문제 k개 선택 (순서 상관 있음)
   */
  private static int dfs(int count) {
    if (k < count) {
      return -1;
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      if (correct[i] == minkyu[i]) {
        result++;
      }
    }

    for (int i = 0; i < n; i++) {
      if (!isSelected[i]) {
        isSelected[i] = true;
        int removed = pushRight(i);
        result = Math.max(result, dfs(count + 1));
        pushRightRollBack(i, removed);

        removed = pullLeft(i);
        result = Math.max(result, dfs(count + 1));
        pullLeftRollBack(i, removed);
        isSelected[i] = false;
      }
    }

    return result;
  }

  private static void pullLeftRollBack(int curr, int removed) {
    for (int i = n - 1; i > curr; i--) {
      minkyu[i] = minkyu[i - 1];
    }
    minkyu[curr] = removed;
  }

  /* 당기기 */
  private static int pullLeft(int curr) {
    int removed = minkyu[curr];
    for (int i = curr; i < n - 1; i++) {
      minkyu[i] = minkyu[i + 1];
    }
    minkyu[n - 1] = 0;

    return removed;
  }

  private static void pushRightRollBack(int curr, int removed) {
    for (int i = curr; i < n - 1; i++) {
      minkyu[i] = minkyu[i + 1];
    }
    minkyu[n - 1] = removed;
  }

  /* 밀기 */
  private static int pushRight(int curr) {
    int removed = minkyu[n - 1];
    for (int i = n - 1; i > curr; i--) {
      minkyu[i] = minkyu[i - 1];
    }
    minkyu[curr] = 0;

    return removed;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    correct = new int[n];
    minkyu = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      correct[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      minkyu[i] = Integer.parseInt(st.nextToken());
    }

    isSelected = new boolean[n];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}