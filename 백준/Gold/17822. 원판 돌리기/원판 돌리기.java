import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m, t;
  static int[][] plates;

  static final int EMPTY = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    plates = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        plates[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      rotatePlates(x, d, k);
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (plates[i][j] != EMPTY) {
          answer += plates[i][j];
        }
      }
    }

    sb.append(answer);
    output();
  }

  private static void rotatePlates(int x, int d, int k) {
    for (int plateNumber = 0; plateNumber < n; plateNumber++) {
      if ((plateNumber + 1) % x != 0) {
        continue;
      }
      rotateSinglePlate(plateNumber, d, k);
    }

    List<Pair> pairs = findAllNears();
    if (pairs.isEmpty()) {
      double avg = getAvg();
      calc(avg);
    } else {
      erase(pairs);
    }
  }

  private static void erase(List<Pair> pairs) {
    for (Pair pair : pairs) {
      plates[pair.plateNumber][pair.index] = EMPTY;
    }
  }

  private static void calc(double avg) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (plates[i][j] == EMPTY) {
          continue;
        }

        if (plates[i][j] < avg) {
          plates[i][j]++;
        } else if (plates[i][j] > avg) {
          plates[i][j]--;
        }
      }
    }
  }

  private static double getAvg() {
    int sum = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (plates[i][j] == EMPTY) {
          continue;
        }

        sum += plates[i][j];
        count++;
      }
    }

    return (double) sum / count;
  }

  private static List<Pair> findAllNears() {
    List<Pair> result = new ArrayList<>();

    for (int plateNumber = 0; plateNumber < n; plateNumber++) {
      for (int i = 0; i < m; i++) {
        if (plates[plateNumber][i] != EMPTY && plates[plateNumber][i] == plates[plateNumber][(i + 1) % m]) {
          result.add(new Pair(plateNumber, i));
          result.add(new Pair(plateNumber, (i + 1) % m));
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int plateNumber = 0; plateNumber < n - 1; plateNumber++) {
        if (plates[plateNumber][i] != EMPTY && plates[plateNumber][i] == plates[plateNumber + 1][i]) {
          result.add(new Pair(plateNumber, i));
          result.add(new Pair(plateNumber + 1, i));
        }
      }
    }

    return result;
  }

  private static void rotateSinglePlate(int plateNumber, int d, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      deque.offer(plates[plateNumber][i]);
    }

    for (int i = 0; i < k; i++) {
      if (d == 0) {
        deque.offerFirst(deque.pollLast());
      } else if (d == 1) {
        deque.offerLast(deque.pollFirst());
      }
    }

    for (int i = 0; i < m; i++) {
      plates[plateNumber][i] = deque.pollFirst();
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Pair {

    int plateNumber, index;

    public Pair(int plateNumber, int index) {
      this.plateNumber = plateNumber;
      this.index = index;
    }
  }

}