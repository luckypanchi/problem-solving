import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, answer;
	static int[][] board;
	static List<Pair> empty;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		empty = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					empty.add(new Pair(i, j));
				}
			}
		}

		answer = Integer.MIN_VALUE;
		List<Integer> selected = new ArrayList<>();
		comb(selected, 0, 0);

		System.out.println(answer);
	}

	private static void comb(List<Integer> selected, int prev, int cnt) {
		if (cnt == 3) {
			int result = check(selected);
			answer = Math.max(answer, result);
			return;
		}

		for (int i = prev; i < empty.size(); i++) {
			selected.add(i);
			comb(selected, i + 1, cnt + 1);
			selected.remove(cnt);
		}
	}

	private static int check(List<Integer> selected) {
		for (int idx : selected) {
			Pair p = empty.get(idx);
			board[p.y][p.x] = 1;
		}

		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 2 && !visited[i][j]) {
					bfs(i, j, visited);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0 && !visited[i][j]) {
					result++;
				}
			}
		}

		for (int idx : selected) {
			Pair p = empty.get(idx);
			board[p.y][p.x] = 0;
		}

		return result;
	}

	private static void bfs(int y, int x, boolean[][] visited) {
		Queue<Pair> que = new ArrayDeque<>();
		visited[y][x] = true;
		que.add(new Pair(y, x));

		while (!que.isEmpty()) {
			Pair curr = que.poll();

			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && board[ny][nx] != 1) {
					visited[ny][nx] = true;
					que.add(new Pair(ny, nx));
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