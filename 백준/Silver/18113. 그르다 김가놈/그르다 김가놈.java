import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, k, m;
  static List<Integer> kimbaps;

  public static void main(String[] args) throws IOException {
    setUp();

    if (kimbaps.isEmpty()) {
      sb.append(-1);
    } else {
      sb.append(solve());
    }

    output();
  }

  private static int solve() {
    int left = 1;
    int right = kimbaps.stream().max(Integer::compareTo).get();
    int answer = -1;

    while (left <= right) {
      int mid = (left + right) / 2;

      int count = 0;
      for (int length : kimbaps) {
        count += length / mid;
      }

      if (count < m) {
        right = mid - 1;
      } else {
        answer = mid;
        left = mid + 1;
      }
    }

    return answer;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    kimbaps = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int length = Integer.parseInt(br.readLine());
      if (length <= k || length == 2 * k) {
        continue;
      }
      if (length < 2 * k) {
        kimbaps.add(length - k);
      } else {
        kimbaps.add(length - 2 * k);
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}