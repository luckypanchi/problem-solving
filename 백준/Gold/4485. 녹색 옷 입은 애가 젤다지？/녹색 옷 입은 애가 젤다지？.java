import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int idx = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			int[][] board = new int[n][n];
			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			PriorityQueue<Pair> que = new PriorityQueue<>();

			dist[0][0] = 0;
			que.offer(new Pair(0, 0, board[0][0]));

			while (!que.isEmpty()) {
				Pair curr = que.poll();

				if (curr.y == n - 1 && curr.x == n - 1) {
					sb.append(String.format("Problem %d: %d\n", idx, curr.cost));
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = curr.y + dy[i];
					int nx = curr.x + dx[i];

					if (0 <= ny && ny < n && 0 <= nx && nx < n) {
						int newCost = board[ny][nx] + curr.cost;

						if (newCost < dist[ny][nx]) {
							dist[ny][nx] = newCost;
							que.offer(new Pair(ny, nx, newCost));
						}
					}

				}
			}

			idx++;
		}

		System.out.println(sb);
	}

	static class Pair implements Comparable<Pair> {

		int y, x, cost;

		public Pair(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair other) {
			return this.cost - other.cost;
		}
	}

}