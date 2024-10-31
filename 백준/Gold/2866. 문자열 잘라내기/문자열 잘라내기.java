import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int r, c;
  static char[][] table;

  public static void main(String[] args) throws IOException {
    setUp();

    int left = 1;
    int right = r - 1;
    int answer = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (check(mid)) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    sb.append(answer);
    output();
  }

  private static boolean check(int start) {
    Set<String> set = new HashSet<>();

    for (int i = 0; i < c; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = start; j < r; j++) {
        s.append(table[i][j]);
      }

      if (set.contains(s.toString())) {
        return false;
      } else {
        set.add(s.toString());
      }
    }

    return true;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    table = new char[c][r];
    for (int i = 0; i < r; i++) {
      String row = br.readLine();
      for (int j = 0; j < c; j++) {
        table[j][i] = row.charAt(j);
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