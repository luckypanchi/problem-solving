import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs();
	}

	private static void bfs() {
		Queue<Integer> que = new ArrayDeque<>();
		int[] visited = new int[100001];
		que.offer(n);
		visited[n] = 1;

		while (!que.isEmpty()) {
			int curr = que.poll();

			if (curr == k) {
				System.out.println(visited[curr] - 1);
				return;
			}

			int next = curr + 1;
			if (next < 100001 && visited[next] == 0) {
				visited[next] = visited[curr] + 1;
				que.offer(next);
			}

			next = curr - 1;
			if (0 <= next && visited[next] == 0) {
				visited[next] = visited[curr] + 1;
				que.offer(next);
			}

			next = curr * 2;
			if (next < 100001 && visited[next] == 0) {
				visited[next] = visited[curr] + 1;
				que.offer(next);
			}

		}
	}

}