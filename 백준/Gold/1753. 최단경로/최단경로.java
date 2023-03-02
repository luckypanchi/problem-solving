import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int v, e, k;
	static int[] results;
	static PriorityQueue<Node> priorityQueue;
	static Map<Integer, List<Node>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		results = new int[v + 1];
		for (int i = 0; i < v + 1; i++) {
			results[i] = Integer.MAX_VALUE;
		}
		graph = new HashMap<>();
		for (int i = 1; i < v + 1; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(k, 0));
		results[k] = 0;
		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();
			if (node.cost <= results[node.nodeNumber]) {
				for (Node nextNode : graph.get(node.nodeNumber)) {
					int nextCost = node.cost + nextNode.cost;
					if (nextCost < results[nextNode.nodeNumber]) {
						results[nextNode.nodeNumber] = nextCost;
						priorityQueue.add(new Node(nextNode.nodeNumber, nextCost));
					}
				}
			}
		}
		for (int i = 1; i < v + 1; i++) {
			if (results[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(results[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {

		int cost;
		int nodeNumber;

		public Node(int nodeNumber, int cost) {
			this.nodeNumber = nodeNumber;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}

}