import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int start, end;
  static long[] unitSum;

  public static void main(String[] args) throws IOException {
    setUp();

    unitSum = new long[10];
    unitSum[1] = 45;
    for (int i = 2; i < 10; i++) {
      unitSum[i] = 45 * (long) Math.pow(10, i - 1) + 10 * unitSum[i - 1];
    }

    sb.append(getAccSum(end) - getAccSum(start - 1));

    output();
  }

  private static long getAccSum(long n) {
    if (n <= 0) {
      return 0;
    }

    String str = Long.toString(n);
    long head = str.charAt(0) - '0';
    int length = str.length() - 1;
    long k = (long) Math.pow(10, length);
    long remain = n - head * k;

    long sum = head * unitSum[length] + head * (remain + 1);
    for (int i = 1; i < head; i++) {
      sum += i * k;
    }

    return sum + getAccSum(remain);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}