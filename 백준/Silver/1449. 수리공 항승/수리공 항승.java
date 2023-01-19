import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] leaks = new int[n];
    for (int i = 0; i < n; i++) {
      leaks[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(leaks);

    int start = leaks[0];
    int cnt = 1;

    for (int i = 1; i < n; i++) {
      if (start + t <= leaks[i]) {
        start = leaks[i];
        cnt++;
      }
    }

    System.out.println(cnt);
  }
}
