import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] lessons;
  static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(lessons, (o1, o2) -> o1[0] - o2[0]);

    int answer = 0;
    for (int[] lesson : lessons) {
      int startTime = lesson[0];
      int endTime = lesson[1];

      while (!pq.isEmpty() && pq.peek() <= startTime) {
        pq.poll();
      }

      pq.offer(endTime);
      answer = Math.max(answer, pq.size());
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    lessons = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      lessons[i][0] = Integer.parseInt(st.nextToken());
      lessons[i][1] = Integer.parseInt(st.nextToken());
    }

    pq = new PriorityQueue<>();

  }

  private class Lesson {

    int startTime;
    int endTime;

    public Lesson(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}