import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int n, m;
  static List<Product> products;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    setUp();

    int answer = dfs(0, 0);

    sb.append(answer);

    output();
  }

  private static int dfs(int curr, int weight) {
    if (m < weight) {
      return Integer.MIN_VALUE;
    }
    if (curr == products.size()) {
      return 0;
    }
    if (dp[curr][weight] != -1) {
      return dp[curr][weight];
    }

    Product product = products.get(curr);
    int result = Math.max(dfs(curr + 1, weight), dfs(curr + 1, weight + product.weight) + product.value);

    dp[curr][weight] = result;

    return result;
  }

  private static void setUp() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    products = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      int count = 1;
      while (k - count > 0) {
        products.add(new Product(count * v, count * c));
        k -= count;
        count *= 2;
      }

      if (k != 0) {
        products.add(new Product(k * v, k * c));
      }
    }

    dp = new int[products.size()][m + 1];
    for (int i = 0; i < products.size(); i++) {
      Arrays.fill(dp[i], -1);
    }
  }

  private static void output() throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static class Product {

    int weight, value;

    public Product(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Product{" +
          "weight=" + weight +
          ", value=" + value +
          '}';
    }
  }

}