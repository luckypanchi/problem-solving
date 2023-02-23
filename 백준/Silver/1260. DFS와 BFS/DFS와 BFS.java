import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, v;
	static HashMap<Integer, List<Integer>> graph;
	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph.get(i));
		}

		sb = new StringBuilder();

		visited = new boolean[n + 1];
		visited[v] = true;
		dfs(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(v);

		System.out.println(sb);
	}

	private static void dfs(int curr) {
		sb.append(curr).append(" ");

		for (Integer nextNode : graph.get(curr)) {
			if (!visited[nextNode]) {
				visited[nextNode] = true;
				dfs(nextNode);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(start);
		visited[start] = true;

		while (!que.isEmpty()) {
			int node = que.poll();
			sb.append(node).append(" ");
			for (Integer nextNode : graph.get(node)) {
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					que.offer(nextNode);
				}
			}
		}
	}

}