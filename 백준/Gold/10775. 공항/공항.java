import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int gateCount, planeCount;
  static int[] targetGates;
  static int[] gateParents;

  public static void main(String[] args) throws IOException {
    setUp();

    gateParents = new int[gateCount + 1];
    for (int i = 0; i < gateCount + 1; i++) {
      gateParents[i] = i;
    }

    int answer = 0;
    for (int target : targetGates) {
      int targetParent = find(target);
      if (targetParent == 0) {
        break;
      }
      answer++;
      union(targetParent, targetParent - 1);
    }

    sb.append(answer);
    output();
  }

  private static int find(int x) {
    if (gateParents[x] != x) {
      gateParents[x] = find(gateParents[x]);
    }

    return gateParents[x];
  }

  private static void union(int x, int y) {
    int parentX = find(x);
    int parentY = find(y);

    if (parentX < parentY) {
      gateParents[parentY] = parentX;
    } else if (parentY < parentX) {
      gateParents[parentX] = parentY;
    }
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    gateCount = Integer.parseInt(br.readLine());
    planeCount = Integer.parseInt(br.readLine());
    targetGates = new int[planeCount];
    for (int i = 0; i < planeCount; i++) {
      targetGates[i] = Integer.parseInt(br.readLine());
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

}