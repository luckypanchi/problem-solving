import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, maxSong, minGuitar;
  static String[][] guitars;

  public static void main(String[] args) throws IOException {
    setUp();

    maxSong = 0;
    minGuitar = Integer.MAX_VALUE;

    subset(0, 0, new boolean[m]);

    if (maxSong == 0) {
      sb.append(-1);
    } else {
      sb.append(minGuitar);
    }

    output();
  }

  private static void subset(int curr, int count, boolean[] flag) {
    if (curr == n) {
      int songCount = 0;
      for (int i = 0; i < m; i++) {
        if (flag[i]) {
          songCount++;
        }
      }

      if (maxSong < songCount) {
        maxSong = songCount;
        minGuitar = count;
      } else if (maxSong == songCount) {
        minGuitar = Math.min(minGuitar, count);
      }
      return;
    }

    subset(curr + 1, count, flag);

    boolean[] currFlag = new boolean[m];
    for (int i = 0; i < m; i++) {
      if (flag[i] || guitars[curr][1].charAt(i) == 'Y') {
        currFlag[i] = true;
      }
    }
    subset(curr + 1, count + 1, currFlag);

  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    guitars = new String[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      guitars[i][0] = st.nextToken();
      guitars[i][1] = st.nextToken();
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}