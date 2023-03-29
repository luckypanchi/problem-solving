import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, answer;
	static int[][] costs;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		costs = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(i, i, 0, 0);
		}

		System.out.println(answer);
	}

	private static void dfs(int start, int curr, int sum, int cnt) {
		if (cnt == n - 1) {
			if (costs[curr][start] != 0) {
				sum += costs[curr][start];
				answer = Math.min(answer, sum);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i] && costs[curr][i] != 0) {
				visited[i] = true;
				dfs(start, i, sum + costs[curr][i], cnt + 1);
				visited[i] = false;
			}
		}
	}

}