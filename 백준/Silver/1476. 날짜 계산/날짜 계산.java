import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int rE = Integer.parseInt(st.nextToken()) % 15;
    int rS = Integer.parseInt(st.nextToken()) % 28;
    int rM = Integer.parseInt(st.nextToken()) % 19;

    int answer = 1;

    while (true) {
      if (answer % 15 == rE && answer % 28 == rS && answer % 19 == rM) {
        break;
      } else {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
