import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String start = br.readLine();

    if (start.length() == 1) {
      start = "0" + start;
    }

    String prevNumber = start;
    String newNumber = start;
    int count = 0;

    do {
      count++;
      prevNumber = newNumber;

      String tmp = Integer.toString(
        Character.getNumericValue(prevNumber.charAt(0)) +
        Character.getNumericValue(prevNumber.charAt(1))
      );

      newNumber =
        String.valueOf(prevNumber.charAt(prevNumber.length() - 1)) +
        String.valueOf(tmp.charAt(tmp.length() - 1));
    } while (!start.equals(newNumber));

    bw.write(String.valueOf(count));

    br.close();
    bw.close();
  }

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }
}
