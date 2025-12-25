import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int[] parents;
  static int[] groupSize;
  static Map<String, Integer> idMap;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int testcases = Integer.parseInt(br.readLine());

    while (testcases-- > 0) {
      int f = Integer.parseInt(br.readLine());
      parents = new int[2 * 100_000 + 1];
      groupSize = new int[2 * 100_000 + 1];

      for (int i = 0; i < 2 * 100_000 + 1; i++) {
        parents[i] = i;
        groupSize[i] = 1;
      }

      idMap = new HashMap<>();
      for (int i = 0; i < f; i++) {
        st = new StringTokenizer(br.readLine());
        String friend1 = st.nextToken();
        String friend2 = st.nextToken();

        int id1 = getId(idMap, friend1);
        int id2 = getId(idMap, friend2);

        sb.append(union(id1, id2)).append("\n");
      }
    }

    output();
  }

  private static int find(int x) {
    if (parents[x] != x) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }

  private static int union(int a, int b) {
    int parentA = find(a);
    int parentB = find(b);

    if (parentA < parentB) {
      parents[parentB] = parentA;
      groupSize[parentA] += groupSize[parentB];
      groupSize[parentB] = 0;
      return groupSize[parentA];
    } else if (parentB < parentA) {
      parents[parentA] = parentB;
      groupSize[parentB] += groupSize[parentA];
      groupSize[parentA] = 0;
      return groupSize[parentB];
    } else {
      return groupSize[parentA];
    }
  }

  private static int getId(Map<String, Integer> idMap, String name) {
    if (idMap.containsKey(name)) {
      return idMap.get(name);
    }

    int nextId = idMap.size() + 1;
    idMap.put(name, nextId);
    return nextId;
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}