import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static String target;
  static int q;
  static int[][] prefixSum;

  public static void main(String[] args) throws IOException {
    setUp();

    prefixSum = new int[target.length() + 1][26];
    for (int i = 1; i < target.length() + 1; i++) {
      for (int j = 0; j < 26; j++) {
        prefixSum[i][j] += prefixSum[i - 1][j];
      }
      int s = target.charAt(i - 1) - 'a';
      prefixSum[i][s]++;
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int t = st.nextToken().charAt(0) - 'a';
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append(prefixSum[end + 1][t] - prefixSum[start][t]).append("\n");
    }

    System.out.println(sb);
  }

  private static void setUp() throws IOException {
    target = br.readLine();
    q = Integer.parseInt(br.readLine());
  }
}