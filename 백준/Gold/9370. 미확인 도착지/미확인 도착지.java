import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int dest;
    int dist;

    public Node(int dest, int dist) {
        this.dest = dest;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

public class Main {

    static int n, m, t;
    static int s, g, h;
    static int mid;
    static Map<Integer, List<Node>> graph;
    static List<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new HashMap<>();
            for (int i = 1; i < n + 1; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));

                if ((a == g || a == h) && (b == g || b == h)) {
                    mid = d;
                }
            }

            int[] distanceFromStart = dijkstra(s);
            int[] distanceFromG = dijkstra(g);
            int[] distanceFromH = dijkstra(h);

            results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int candidate = Integer.parseInt(br.readLine());
                int dist1 = distanceFromStart[g] + mid + distanceFromH[candidate];
                int dist2 = distanceFromStart[h] + mid + distanceFromG[candidate];
                int dist = distanceFromStart[candidate];
                if ((dist == dist1) || (dist == dist2)) {
                    results.add(candidate);
                }
            }

            Collections.sort(results);

            for (Integer result : results) {
                sb.append(result).append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, distances[start]));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();

            if (distances[currNode.dest] < currNode.dist) {
                continue;
            }

            for (Node nextNode : graph.get(currNode.dest)) {
                int distance = distances[currNode.dest] + nextNode.dist;
                if (distance < distances[nextNode.dest]) {
                    distances[nextNode.dest] = distance;
                    pq.add(new Node(nextNode.dest, distance));
                }
            }
        }

        return distances;
    }

}