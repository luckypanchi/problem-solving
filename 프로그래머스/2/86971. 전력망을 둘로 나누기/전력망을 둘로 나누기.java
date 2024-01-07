import java.util.*;

class Solution {
    static int N;
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;
    static int answer;

    public int solution(int n, int[][] wires) {
        N = n;
        graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        answer = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            bfs(wire[0], wire[1]);
        }

        return answer;
    }

    private static void bfs(int node1, int node2) {
        Queue<Integer> que = new ArrayDeque<>();
        visited = new boolean[N + 1];

        que.add(1);
        visited[1] = true;
        int nodeCount = 1;

        while (!que.isEmpty()) {
            int currNode = que.poll();

            for (int nextNode : graph.get(currNode)) {
                if (visited[nextNode] || (currNode == node1 && nextNode == node2) || (currNode == node2 && nextNode == node1)) {
                    continue;
                }

                nodeCount++;
                visited[nextNode] = true;
                que.add(nextNode);
            }
        }

        answer = Math.min(answer, Math.abs(2 * nodeCount - N));
    }
}