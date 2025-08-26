import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static Map<Integer, Deque<Integer>> map;
  static int[] sushiList;
  static int[] counter;

  public static void main(String[] args) throws IOException {
    setUp();

    for (int sushi : sushiList) {
      if (!map.get(sushi).isEmpty()) {
        int person = map.get(sushi).pollFirst();
        counter[person]++;
      }
    }

    for (int i = 0; i < n; i++) {
      sb.append(counter[i]).append(" ");
    }
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new HashMap<>();
    for (int i = 0; i < 200_001; i++) {
      map.put(i, new ArrayDeque<>());
    }
    sushiList = new int[m];
    counter = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      for (int j = 0; j < k; j++) {
        map.get(Integer.parseInt(st.nextToken())).add(i);
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      sushiList[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}