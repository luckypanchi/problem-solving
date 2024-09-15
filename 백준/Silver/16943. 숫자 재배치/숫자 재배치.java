import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static char[] given;
  static int target, answer;
  static int[] selected;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    answer = -1;
    permutation(0);

    sb.append(answer);

    output();
  }

  private static void permutation(int curr) {
    if (curr == given.length) {
      String result = "";
      for (int i = 0; i < selected.length; i++) {
        result += given[selected[i]];
      }
      int res = Integer.parseInt(result);
      if (res < target) {
        answer = Math.max(answer, res);
      }
      return;
    }

    for (int i = 0; i < given.length; i++) {
      if (!isSelected[i]) {
        if (curr == 0 && given[i] == '0') {
          continue;
        }
        isSelected[i] = true;
        selected[curr] = i;
        permutation(curr + 1);
        isSelected[i] = false;
      }
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    given = st.nextToken().toCharArray();
    target = Integer.parseInt(st.nextToken());

    selected = new int[given.length];
    isSelected = new boolean[given.length];
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}