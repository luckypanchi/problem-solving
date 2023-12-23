import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static HashMap<Integer, List<Node>> graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b) {
                continue;
            }

            graph.get(a).add(new Node(b, c));
        }

        dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[1][1] = 0;
        for (int currCity = 1; currCity < n; currCity++) {
            for (int arrivedCnt = 1; arrivedCnt < m; arrivedCnt++) {
                if (dp[currCity][arrivedCnt] == -1) {
                    continue;
                }

                for (Node node : graph.get(currCity)) {
                    dp[node.nextCity][arrivedCnt + 1] = Math.max(dp[node.nextCity][arrivedCnt + 1], dp[currCity][arrivedCnt] + node.cost);
                }
            }
        }

        int answer = Arrays.stream(dp[n]).max().getAsInt();

        System.out.println(answer);
    }

    static class Node {

        public int nextCity;
        public int cost;

        public Node(int nextCity, int cost) {
            this.nextCity = nextCity;
            this.cost = cost;
        }
    }
}