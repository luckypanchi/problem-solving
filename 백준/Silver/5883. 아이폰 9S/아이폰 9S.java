import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] sizes;

  public static void main(String[] args) throws IOException {
    setUp();

    Set<Integer> set = new HashSet<>();
    for (int sz : sizes) {
      set.add(sz);
    }

    int answer = 0;
    for (int target : set) {
      int curr = -1;
      int length = 0;

      for (int num : sizes) {
        if (num == target) {
          continue;
        }

        if (curr == -1) {
          curr = num;
          length = 1;
        } else if (curr != num) {
          answer = Math.max(answer, length);
          curr = num;
          length = 1;
        } else {
          length++;
        }
      }

      answer = Math.max(answer, length);
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    sizes = new int[n];
    for (int i = 0; i < n; i++) {
      sizes[i] = Integer.parseInt(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}