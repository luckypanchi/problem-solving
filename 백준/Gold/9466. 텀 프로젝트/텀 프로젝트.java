import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] students;
  static boolean[] visited, isFinished;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());
    while (testcases-- > 0) {
      n = Integer.parseInt(br.readLine());
      students = new int[n + 1];
      visited = new boolean[n + 1];
      isFinished = new boolean[n + 1];
      answer = 0;

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i < n + 1; i++) {
        students[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 1; i < n + 1; i++) {
        if (!isFinished[i]) {
          dfs(i);
        }
      }

      sb.append(n - answer).append("\n");
    }

    output();
  }

  private static void dfs(int curr) {
    if (isFinished[curr]) {
      return;
    }
    if (visited[curr]) {
      answer++;
      isFinished[curr] = true;
    }

    visited[curr] = true;
    dfs(students[curr]);
    isFinished[curr] = true;

  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}