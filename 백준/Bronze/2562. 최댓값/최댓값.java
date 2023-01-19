import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int maxNum = Integer.MIN_VALUE;
    int maxIdx = 0;

    for (int i = 0; i < 9; i++) {
      int inputNumber = Integer.parseInt(br.readLine());
      if (maxNum < inputNumber) {
        maxNum = inputNumber;
        maxIdx = i + 1;
      }
    }
    System.out.println(maxNum);
    System.out.println(maxIdx);
  }
}
