import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int hours = Integer.parseInt(st.nextToken());
    int minutes = Integer.parseInt(st.nextToken());

    if (minutes >= 45) {
      sb.append(hours).append(" ").append(minutes - 45);
    } else {
      sb
        .append(hours - 1 < 0 ? 23 : hours - 1)
        .append(" ")
        .append(minutes + 15);
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }
}
