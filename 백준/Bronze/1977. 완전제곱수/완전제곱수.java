import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> resultList = new ArrayList<>();

    for (int i = m; i < n + 1; i++) {
      if (Math.sqrt(i) % 1 == 0) {
        resultList.add(i);
      }
    }

    if (resultList.size() == 0) {
      sb.append(-1);
    } else {
      int sum = 0;
      for (int num : resultList) {
        sum += num;
      }
      sb.append(sum).append("\n").append(resultList.get(0));
    }
    System.out.println(sb);
  }
}
