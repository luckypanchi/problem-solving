import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, w, MAX;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    MAX = Integer.parseInt(st.nextToken());

    Queue<Integer> ready = new LinkedList<>();
    Queue<Integer> bridge = new LinkedList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      ready.add(Integer.parseInt(st.nextToken()));
    }
    for (int i = 0; i < w; i++) {
      bridge.add(0);
    }

    int time = 0;
    int weight = 0;

    while (!ready.isEmpty() || !bridge.isEmpty()) {
      weight -= bridge.poll();
      if (!ready.isEmpty()) {
        if (weight + ready.peek() <= MAX) {
          int newTruck = ready.poll();
          bridge.add(newTruck);
          weight += newTruck;
        } else {
          bridge.add(0);
        }
      }
      time++;
    }
    System.out.println(time);
  }
}
