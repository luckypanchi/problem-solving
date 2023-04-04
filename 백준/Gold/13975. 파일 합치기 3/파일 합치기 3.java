import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    long[] answers = new long[tc];
    for (int i = 0; i < tc; i++) {
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Long> files = new PriorityQueue<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens()) {
        files.offer(Long.parseLong(st.nextToken()));
      }

      long answer = 0;
      while (files.size() > 1) {
        long result = files.poll() + files.poll();
        answer += result;
        files.offer(result);
      }
      answers[i] = answer;
    }
    for (int i = 0; i < tc; i++) {
      System.out.println(answers[i]);
    }
  }
}
