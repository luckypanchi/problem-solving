import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] levels, prefixSum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    levels = new int[n + 1];
    prefixSum = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n + 1; i++) {
      levels[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 2; i < n + 1; i++) {
      prefixSum[i] = prefixSum[i - 1];
      if (levels[i - 1] > levels[i]) {
        prefixSum[i]++;
      }
    }

    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      sb.append(prefixSum[y] - prefixSum[x]).append("\n");
    }

    output();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}