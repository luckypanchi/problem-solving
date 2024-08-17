import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] array;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcases; tc++) {
      setUp();

      List<Integer> answer = new ArrayList<>();

      PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> right = new PriorityQueue<>();

      answer.add(array[0]);
      int mid = array[0];
      for (int i = 1; i < n; i++) {
        if (array[i] < mid) {
          left.offer(array[i]);
        } else {
          right.offer(array[i]);
        }

        if (i % 2 == 1) {
          continue;
        }

        if (left.size() < right.size()) {
          left.offer(mid);
          mid = right.poll();
        } else if (left.size() > right.size()) {
          right.offer(mid);
          mid = left.poll();
        }
        answer.add(mid);
      }

      sb.append(answer.size()).append("\n");
      for (int i = 0; i < answer.size(); i++) {
        if (i > 0 && i % 10 == 0) {
          sb.append("\n");
        }
        sb.append(answer.get(i)).append(" ");
      }
      sb.append("\n");
    }

    output();
  }

  private static void setUp() throws IOException {
    n = Integer.parseInt(br.readLine());
    array = new int[n];
    int start = 0;
    while (start < n) {
      st = new StringTokenizer(br.readLine());
      int limit = Math.min(10, n - start);
      for (int i = 0; i < limit; i++) {
        array[start + i] = Integer.parseInt(st.nextToken());
      }
      start += 10;
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}