import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

	static int n;
	static int[][] board;
	static int[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			for (int i = 0; i < n; i++) {
				String row = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = row.charAt(j) - '0';
				}
			}
			visited = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}

			bfs();

			sb.append(visited[n - 1][n - 1]).append("\n");

		}

		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(0, 0));
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			Pair curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && board[ny][nx] + visited[curr.y][curr.x] < visited[ny][nx]) {
					visited[ny][nx] = board[ny][nx] + visited[curr.y][curr.x];
					queue.offer(new Pair(ny, nx));
				}
			}
		}

	}

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}