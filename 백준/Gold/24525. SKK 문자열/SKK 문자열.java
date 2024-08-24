import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String string;
  static int[] prefixSum, count, entryIndex, exitIndex;
  static int n;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int i = 0; i < n; i++) {
      if (string.charAt(i) == 'S') {
        prefixSum[i + 1] += 2;
        count[i + 1] = 1;
      } else if (string.charAt(i) == 'K') {
        prefixSum[i + 1] -= 1;
        count[i + 1] = 1;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      prefixSum[i] += prefixSum[i - 1];
      count[i] += count[i - 1];
    }

    for (int i = 0; i < n + 1; i++) {
      int value = prefixSum[i] + n;
      entryIndex[value] = Math.min(entryIndex[value], i);
      exitIndex[value] = Math.max(exitIndex[value], i);
    }

    int answer = -1;
    for (int v = 0; v < 3 * n + 1; v++) {
      if (exitIndex[v] == -1) {
        continue;
      }
      if (entryIndex[v] != exitIndex[v] && count[entryIndex[v]] != count[exitIndex[v]]) {
        answer = Math.max(answer, exitIndex[v] - entryIndex[v]);
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    string = br.readLine();
    n = string.length();
    prefixSum = new int[n + 1];
    count = new int[n + 1];
    entryIndex = new int[3 * n + 1];
    exitIndex = new int[3 * n + 1];

    Arrays.fill(entryIndex, n);
    Arrays.fill(exitIndex, -1);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}