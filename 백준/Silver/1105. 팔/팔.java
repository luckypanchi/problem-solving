import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static String left, right;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = 0;
    if (left.length() == right.length()) {
      for (int i = 0; i < left.length(); i++) {
        if (left.charAt(i) != right.charAt(i)) {
          break;
        }
        
        if (left.charAt(i) == '8') {
          answer++;
        }
      }
    }

    sb.append(answer);

    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    left = st.nextToken();
    right = st.nextToken();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}