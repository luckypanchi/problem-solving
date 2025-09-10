import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static char[] word;

  public static void main(String[] args) throws IOException {
    setUp();

    sb.append(solve(0, 0));

    output();
  }

  private static long solve(int curr, int isIncluded) {
    if (2 < curr && check(curr)) {
      return 0;
    }
    if (curr == word.length) {
      return isIncluded;
    }

    if (word[curr] != '_') {
      return word[curr] == 'L' ? solve(curr + 1, 1) : solve(curr + 1, isIncluded);
    }

    long count = 0L;

    word[curr] = 'A';
    count += 5 * solve(curr + 1, isIncluded);

    word[curr] = 'B';
    count += 20 * solve(curr + 1, isIncluded);

    word[curr] = 'L';
    count += solve(curr + 1, 1);

    word[curr] = '_';

    return count;
  }

  private static boolean check(int curr) {
    if (isVowel(word[curr - 3]) && isVowel(word[curr - 2]) && isVowel(word[curr - 1])) {
      return true;
    }

    if (!isVowel(word[curr - 3]) && !isVowel(word[curr - 2]) && !isVowel(word[curr - 1])) {
      return true;
    }

    return false;
  }

  private static boolean isVowel(char ch) {
    for (char vowel : "AEIOU".toCharArray()) {
      if (vowel == ch) {
        return true;
      }
    }
    return false;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    word = br.readLine().toCharArray();
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}