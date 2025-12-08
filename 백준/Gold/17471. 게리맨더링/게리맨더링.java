import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static int[] peopleCount;
  static Map<Integer, List<Integer>> map;
  static int totalCount, answer;
  static boolean[] isSelected;

  public static void main(String[] args) throws IOException {
    setUp();

    totalCount = Arrays.stream(peopleCount).sum();
    answer = totalCount;
    isSelected = new boolean[n + 1];

    combination(1);

    if (answer == totalCount) {
      answer = -1;
    }
    sb.append(answer);
    output();
  }

  private static int countZone1PeopleCount() {
    int count = 0;
    for (int i = 1; i < n + 1; i++) {
      if (isSelected[i]) {
        count += peopleCount[i];
      }
    }
    return count;
  }

  private static int selectStart(boolean selectedStatus) {
    for (int i = 1; i < n + 1; i++) {
      if (isSelected[i] == selectedStatus) {
        return i;
      }
    }
    return -1;
  }

  private static boolean isZoneConnected(boolean selectedStatus) {
    boolean[] visited = new boolean[n + 1];
    int start = selectStart(selectedStatus);
    visited[start] = true;

    Deque<Integer> que = new ArrayDeque<>();
    que.offerLast(start);

    while (!que.isEmpty()) {
      int curr = que.pollFirst();

      for (int next : map.get(curr)) {
        if (!visited[next] && isSelected[next] == selectedStatus) {
          visited[next] = true;
          que.offerLast(next);
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      if (isSelected[i] == selectedStatus && !visited[i]) {
        return false;
      }
    }

    return true;
  }

  private static boolean checkZoneCount() {
    int zone1 = 0;
    for (int i = 1; i < n + 1; i++) {
      if (isSelected[i]) {
        zone1++;
      }
    }
    return zone1 != n && zone1 != 0;
  }

  private static void solve() {
    if (checkZoneCount() && isZoneConnected(true) && isZoneConnected(false)) {
      int zoneCount = countZone1PeopleCount();
      answer = Math.min(answer, Math.abs(totalCount - 2 * zoneCount));
    }
  }

  private static void combination(int curr) {
    if (curr == n + 1) {
      solve();
      return;
    }

    isSelected[curr] = true;
    combination(curr + 1);
    isSelected[curr] = false;
    combination(curr + 1);
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    peopleCount = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      peopleCount[i + 1] = Integer.parseInt(st.nextToken());
    }
    map = new HashMap<>();
    for (int i = 1; i < n + 1; i++) {
      map.put(i, new ArrayList<>());
      st = new StringTokenizer(br.readLine());
      int nearCount = Integer.parseInt(st.nextToken());
      for (int j = 0; j < nearCount; j++) {
        map.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}