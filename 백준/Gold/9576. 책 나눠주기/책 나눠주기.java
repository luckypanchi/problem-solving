import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static boolean[] isSelected;
  static PriorityQueue<Pair> pq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int tcs = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < tcs; tc++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      isSelected = new boolean[n + 1];
      pq = new PriorityQueue<>();
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        pq.add(new Pair(a, b));
      }
      sb.append(solve()).append("\n");

    }

    output();
  }

  private static int solve() {
    int answer = 0;

    while (!pq.isEmpty()) {
      Pair pair = pq.poll();
      for (int i = pair.a; i < pair.b + 1; i++) {
        if (!isSelected[i]) {
          isSelected[i] = true;
          answer++;
          break;
        }
      }
    }

    return answer;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair implements Comparable<Pair> {

    int a;
    int b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Pair other) {
      if (this.b != other.b) {
        return this.b - other.b;
      }
      return this.a - other.a;
    }
  }

}