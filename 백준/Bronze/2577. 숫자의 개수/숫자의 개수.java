import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int result = 1;
    int[] counter = new int[10];
    for (int i = 0; i < 3; i++) {
      result *= Integer.parseInt(br.readLine());
    }

    char[] charArray = String.valueOf(result).toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      counter[charArray[i] - '0']++;
    }
    for (int i = 0; i < counter.length; i++) {
      sb.append(counter[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }
}
