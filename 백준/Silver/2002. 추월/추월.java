import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  static int n;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    HashMap<String, Integer> cars = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String carNumber = br.readLine();
      cars.put(carNumber, i);
    }

    int[] output = new int[n];

    for (int i = 0; i < n; i++) {
      String carNumber = br.readLine();
      output[i] = cars.get(carNumber);
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (output[i] > output[j]) {
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);
  }
}
