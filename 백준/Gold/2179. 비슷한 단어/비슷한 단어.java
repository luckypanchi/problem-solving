import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static List<String> words;

  public static void main(String[] args) throws IOException {
    setUp();

    int maxLength = -1;
    String s = null;
    String t = null;

    for (int i = 0; i < n; i++) {
      String word1 = words.get(i);
      for (int j = i + 1; j < n; j++) {
        String word2 = words.get(j);
        int prefixLength = findPrefixLength(word1, word2);
        if (maxLength < prefixLength) {
          maxLength = prefixLength;
          s = word1;
          t = word2;
        }
      }
    }

    sb.append(s).append("\n").append(t);

    output();
  }

  private static int findPrefixLength(String word1, String word2) {
    int length = Math.min(word1.length(), word2.length());
    int prefixLength = 0;
    for (int i = 0; i < length; i++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        prefixLength++;
      } else {
        break;
      }
    }

    return prefixLength;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    words = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      words.add(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}