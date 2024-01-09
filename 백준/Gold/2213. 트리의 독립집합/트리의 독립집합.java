import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] weights;
    static Map<Integer, List<Integer>> graph;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> visitedNodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        weights = new int[n + 1];
        graph = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            graph.put(i, new ArrayList<>());
        }

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {
                break;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        visited[1] = true;
        dfs(1);

        int answer = Arrays.stream(dp[1]).max().getAsInt();
        sb.append(answer).append("\n");

        visited = new boolean[n + 1];
        visitedNodeList = new ArrayList<>();

        visited[1] = true;
        if (dp[1][0] < dp[1][1]) {
            trace(1, false);
        } else {
            trace(1, true);
        }

        Collections.sort(visitedNodeList);
        for (Integer node : visitedNodeList) {
            sb.append(node).append(" ");
        }

        System.out.println(sb);

    }

    private static void dfs(int currNode) {
        dp[currNode][0] += weights[currNode];
        for (Integer nextNode : graph.get(currNode)) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
                dp[currNode][0] += dp[nextNode][1];
                dp[currNode][1] += Arrays.stream(dp[nextNode]).max().getAsInt();
            }
        }
    }

    private static void trace(int currNode, boolean isIncluded) {
        if (isIncluded) {
            visitedNodeList.add(currNode);
            for (Integer nextNode : graph.get(currNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    trace(nextNode, false);
                }
            }
        } else {
            for (Integer nextNode : graph.get(currNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    if (dp[nextNode][0] < dp[nextNode][1]) {
                        trace(nextNode, false);
                    } else {
                        trace(nextNode, true);
                    }
                }
            }
        }

    }
}