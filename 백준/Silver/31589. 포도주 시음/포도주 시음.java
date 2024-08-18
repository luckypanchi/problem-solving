import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k;
  static int[] tastes;

  public static void main(String[] args) throws IOException {
    setUp();

    int front = 0;
    long answer = 0;
    int left = 0;
    int right = n - 1;

    while (k > 1) {
      answer += tastes[right] - tastes[left];
      left++;
      right--;
      k -= 2;
    }
    if (k == 0) {
      answer += tastes[left - 1];
    } else {
      answer += tastes[right];
    }

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    tastes = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tastes[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(tastes);
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}