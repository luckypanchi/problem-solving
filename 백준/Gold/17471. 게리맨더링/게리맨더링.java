import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] pp;
	static Map<Integer, List<Integer>> map;
	static boolean[] isSelected, visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		pp = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			pp[i] = Integer.parseInt(st.nextToken());
		}
		map = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(i, new ArrayList<>());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				map.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		answer = Integer.MAX_VALUE;
		isSelected = new boolean[n + 1];
		subset(0, 0, 0);

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.println(answer);

	}

	private static void subset(int cnt, int curr, int visitedCnt) {
		if (cnt == n) {
			solve();
			return;
		}

		subset(cnt + 1, curr + 1, visitedCnt);
		isSelected[curr] = true;
		subset(cnt + 1, curr + 1, visitedCnt + 1);
		isSelected[curr] = false;

	}

	private static void solve() {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		for (int i = 1; i < n + 1; i++) {
			if (isSelected[i]) {
				listA.add(i);
			} else {
				listB.add(i);
			}
		}

		if (listA.size() == 0 || listB.size() == 0) {
			return;
		}

		visited = new boolean[n + 1];
		bfs(listA);
		bfs(listB);

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				return;
			}
		}

		int sum1 = 0;
		int sum2 = 0;

		for (int node : listA) {
			sum1 += pp[node];
		}

		for (int node : listB) {
			sum2 += pp[node];
		}

		answer = Math.min(answer, Math.abs(sum1 - sum2));
	}

	private static void bfs(List<Integer> list) {
		Queue<Integer> queue = new ArrayDeque<>();
		int start = list.get(0);
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (Integer nextNode : map.get(node)) {
				if (list.contains(nextNode) && !visited[nextNode]) {
					visited[nextNode] = true;
					queue.add(nextNode);
				}
			}
		}
	}

}