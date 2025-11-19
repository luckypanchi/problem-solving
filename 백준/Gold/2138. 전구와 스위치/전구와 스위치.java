import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static boolean[] now1, now2;
  static boolean[] target;

  public static void main(String[] args) throws IOException {
    setUp();

    int count1 = solve(now1);

    now2[0] = !now2[0];
    now2[1] = !now2[1];

    int count2 = solve(now2);

    if (count1 == -1 && count2 == -1) {
      sb.append(-1);
    } else if (count1 == -1) {
      sb.append(count2 + 1);
    } else if (count2 == -1) {
      sb.append(count1);
    } else {
      sb.append(Math.min(count1, count2 + 1));
    }

    output();
  }

  private static int solve(boolean[] now) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (now[i - 1] != target[i - 1]) {
        turn(now, i);
        count++;
      }
    }

    if (now[n - 1] != target[n - 1]) {
      return -1;
    }

    return count;
  }

  private static void turn(boolean[] now, int index) {
    for (int i = index - 1; i < index + 2; i++) {
      if (i < n) {
        now[i] = !now[i];
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    now1 = new boolean[n];
    now2 = new boolean[n];
    target = new boolean[n];

    String row = br.readLine();
    for (int i = 0; i < n; i++) {
      boolean curr = row.charAt(i) == '1';
      now1[i] = curr;
      now2[i] = curr;
    }

    row = br.readLine();
    for (int i = 0; i < n; i++) {
      target[i] = row.charAt(i) == '1';
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}