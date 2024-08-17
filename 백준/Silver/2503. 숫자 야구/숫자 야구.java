import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[][] questions;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    for (int a = 1; a < 10; a++) {
      for (int b = 1; b < 10; b++) {
        for (int c = 1; c < 10; c++) {
          if (a == b || b == c || c == a) {
            continue;
          }

          boolean flag = true;
          for (int i = 0; i < n; i++) {
            int[] result = check(questions[i][0], new int[]{a, b, c});
            if (result[0] != questions[i][1] || result[1] != questions[i][2]) {
              flag = false;
              break;
            }
          }

          if (flag) {
            answer++;
          }

        }
      }

    }

    sb.append(answer);

    output();
  }

  private static int[] check(int target, int[] numbers) {
    int[] result = new int[2];
    String t = String.valueOf(target);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int curr = t.charAt(i) - '0';
        if (curr != numbers[j]) {
          continue;
        }

        if (i == j) {
          result[0]++;
        } else {
          result[1]++;
        }
      }
    }

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    questions = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      questions[i][0] = Integer.parseInt(st.nextToken());
      questions[i][1] = Integer.parseInt(st.nextToken());
      questions[i][2] = Integer.parseInt(st.nextToken());
    }

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}