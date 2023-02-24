import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int n;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = row.charAt(j);
			}
		}

		visited = new boolean[n][n];
		int cnt1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					cnt1++;
					check(i, j);
				}
			}
		}
		sb.append(cnt1).append(" ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'G') {
					board[i][j] = 'R';
				}
			}
		}

		visited = new boolean[n][n];
		int cnt2 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					cnt2++;
					check(i, j);
				}
			}
		}

		sb.append(cnt2);

		System.out.println(sb);

	}

	private static void check(int y, int x) {
		Queue<Pair> que = new ArrayDeque<>();
		que.offer(new Pair(y, x));
		visited[y][x] = true;

		while (!que.isEmpty()) {
			Pair pair = que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = pair.y + dy[i];
				int nx = pair.x + dx[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[ny][nx] && board[ny][nx] == board[y][x]) {
					visited[ny][nx] = true;
					que.offer(new Pair(ny, nx));
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