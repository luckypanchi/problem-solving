import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = m; i < n + 1; i++) {
      if (check(i)) {
        arr.add(i);
      }
    }

    if (arr.size() == 0) {
      System.out.println(-1);
    } else {
      int sum = 0;
      for (int i : arr) {
        sum += i;
      }
      System.out.println(sum);
      System.out.println(arr.get(0));
    }
  }

  static boolean check(int number) {
    if (number == 1) {
      return false;
    }
    for (int i = 2; i < (int) (Math.sqrt(number)) + 1; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
