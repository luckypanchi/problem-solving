import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static Map<Integer, List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
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

		visited = new boolean[n + 1];
		visited[1] = true;
		int answer = dfs(1);

		System.out.println(answer);

	}

	private static int dfs(int curr) {
		int cnt = 0;
		List<Integer> childs = graph.get(curr);
		for (Integer child : childs) {
			if (!visited[child]) {
				visited[child] = true;
				cnt += dfs(child) + 1;
			}
		}
		return cnt;
	}

}