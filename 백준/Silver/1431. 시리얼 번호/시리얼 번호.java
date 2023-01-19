import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {

  String serialNumber;
  int sumOfNumber;

  public Node(String serialNumber) {
    this.serialNumber = serialNumber;
    getSumOfNumber();
  }

  private void getSumOfNumber() {
    for (int i = this.serialNumber.length() - 1; i > -1; i--) {
      char curr = this.serialNumber.charAt(i);
      try {
        this.sumOfNumber += Integer.parseInt(String.valueOf(curr));
      } catch (NumberFormatException e) {}
    }
  }

  @Override
  public int compareTo(Node other) {
    if (this.serialNumber.length() != other.serialNumber.length()) {
      return this.serialNumber.length() - other.serialNumber.length();
    }

    if (this.sumOfNumber != other.sumOfNumber) {
      return this.sumOfNumber - other.sumOfNumber;
    }

    return this.serialNumber.compareTo(other.serialNumber);
  }

  @Override
  public String toString() {
    return this.serialNumber;
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    List<Node> array = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      array.add(new Node(input));
    }

    Collections.sort(array);

    for (int i = 0; i < n; i++) {
      sb.append(array.get(i)).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
  }
}
