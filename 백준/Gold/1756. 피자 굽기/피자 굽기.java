import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int ovenDepth, pizzaCount;
  static int[] ovenSizes;
  static int[] pizzaSizes;

  public static void main(String[] args) throws IOException {
    setUp();

    int depthEnd = ovenDepth - 1;

    for (int i = 0; i < pizzaCount; i++) {
      int currPizza = pizzaSizes[i];

      while (0 <= depthEnd && ovenSizes[depthEnd] < currPizza) {
        depthEnd--;
      }

      if (depthEnd < 0) {
        break;
      }

      depthEnd--;
    }

    int answer = depthEnd < 0 ? 0 : depthEnd + 2;

    sb.append(answer);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    ovenDepth = Integer.parseInt(st.nextToken());
    pizzaCount = Integer.parseInt(st.nextToken());
    ovenSizes = new int[ovenDepth];
    pizzaSizes = new int[pizzaCount];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < ovenDepth; i++) {
      ovenSizes[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < pizzaCount; i++) {
      pizzaSizes[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < ovenDepth; i++) {
      if (ovenSizes[i - 1] < ovenSizes[i]) {
        ovenSizes[i] = ovenSizes[i - 1];
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