import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String s;

  public static void main(String[] args) throws IOException {
    setUp();

    Set<String> set = new HashSet<>();
    for (int start = 0; start < s.length(); start++) {
      for (int end = start + 1; end < s.length() + 1; end++) {
        set.add(s.substring(start, end));
      }
    }

    sb.append(set.size());
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}