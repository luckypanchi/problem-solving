import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] weights;
  static boolean[] isUsed;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(n));
    output();
  }

  private static int solve(int totalCount) {
    if (totalCount == 2) {
      return 0;
    }

    int result = 0;

    for (int i = 1; i < n - 1; i++) {
      if (isUsed[i]) {
        continue;
      }

      isUsed[i] = true;
      int currResult = findLeft(i) * findRight(i) + solve(totalCount - 1);
      isUsed[i] = false;

      result = Math.max(result, currResult);
    }

    return result;
  }

  private static int findLeft(int start) {
    for (int i = start - 1; i >= 0; i--) {
      if (!isUsed[i]) {
        return weights[i];
      }
    }
    return -1;
  }

  private static int findRight(int start) {
    for (int i = start + 1; i < n; i++) {
      if (!isUsed[i]) {
        return weights[i];
      }
    }
    return -1;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    weights = new int[n];
    isUsed = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}