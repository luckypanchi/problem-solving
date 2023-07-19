import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int n, m, r, answer;
    static int[] items;
    static Map<Integer, List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, dist));
            graph.get(b).add(new Node(a, dist));
        }

        answer = Integer.MIN_VALUE;

        for (int start = 1; start < n + 1; start++) {
            int[] distances = dijkstra(start);
            int count = 0;

            for (int i = 1; i < n + 1; i++) {
                if (distances[i] <= m) {
                    count += items[i];
                }
            }

            answer = Integer.max(answer, count);

        }

        sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, distances[0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distances[node.dest] < node.dist) {
                continue;
            }

            for (Node nextNode : graph.get(node.dest)) {
                int distance = node.dist + nextNode.dist;
                if (distance < distances[nextNode.dest]) {
                    distances[nextNode.dest] = distance;
                    pq.add(new Node(nextNode.dest, distance));
                }
            }
        }

        return distances;
    }

    static class Node implements Comparable<Node> {
        public int dest;
        public int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

}