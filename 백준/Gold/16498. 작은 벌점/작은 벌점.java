import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int a, b, c;
  static int[] player1, player2, player3;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(player1);
    Arrays.sort(player2);
    Arrays.sort(player3);

    int answer = Integer.MAX_VALUE;
    for (int p1 : player1) {
      int p2 = findNearest(player2, p1);
      int p3FromP1 = findNearest(player3, p1);
      int p3FromP2 = findNearest(player3, p2);

      answer = Math.min(answer, Math.max(Math.max(p1, p2), p3FromP1) - Math.min(Math.min(p1, p2), p3FromP1));
      answer = Math.min(answer, Math.max(Math.max(p1, p2), p3FromP2) - Math.min(Math.min(p1, p2), p3FromP2));
    }

    sb.append(answer);

    output();
  }

  private static int findNearest(int[] player, int target) {
    int left = 0;
    int right = player.length - 1;
    int index = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (player[mid] <= target) {
        index = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    if (index + 1 < player.length && Math.abs(target - player[index + 1]) < Math.abs(target - player[index])) {
      return player[index + 1];
    }

    return player[index];
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    player1 = new int[a];
    player2 = new int[b];
    player3 = new int[c];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a; i++) {
      player1[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b; i++) {
      player2[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      player3[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}