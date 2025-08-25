import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n;
  static Node[] nodes;

  public static void main(String[] args) throws IOException {
    setUp();

    Arrays.sort(nodes);
    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer = Math.max(answer, nodes[i].index - i);
    }

    sb.append(answer + 1);
    output();
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(Integer.parseInt(br.readLine()), i);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int number, index;

    public Node(int number, int index) {
      this.number = number;
      this.index = index;
    }

    @Override
    public int compareTo(Node o) {
      return this.number - o.number;
    }
  }

}