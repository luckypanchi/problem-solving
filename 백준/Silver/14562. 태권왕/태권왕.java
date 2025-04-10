import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int testcases = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < testcases; tc++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      Deque<int[]> queue = new ArrayDeque<>();
      queue.add(new int[]{s, t, 0});

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        if (cur[0] == cur[1]) {
          sb.append(cur[2]).append("\n");
          break;
        }
        if (cur[0] > cur[1]) {
          continue;
        }
        queue.offer(new int[]{2 * cur[0], cur[1] + 3, cur[2] + 1});
        queue.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1});
      }
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