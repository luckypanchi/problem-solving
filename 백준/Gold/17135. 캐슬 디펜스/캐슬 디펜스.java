import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 0, -1, 0 };

	static int n, m, d;
	static int[][] initBoard;
	static int initTotal, answer;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		initBoard = new int[n][m];
		selected = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				initBoard[i][j] = Integer.parseInt(st.nextToken());
				initTotal += initBoard[i][j];
			}
		}

		answer = Integer.MIN_VALUE;
		comb(0, 0);

		System.out.println(answer);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			int[][] board = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					board[i][j] = initBoard[i][j];
				}
			}
			solve(board);
			return;
		}

		for (int i = start; i < m; i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static void solve(int[][] board) {
		int total = initTotal;
		int cnt = 0;
		while (0 < total) {
			List<int[]> enemies = new ArrayList<>();
			for (int x : selected) {
				kill(n, x, board, enemies);
			}
			for (int[] enemy : enemies) {
				int y = enemy[0];
				int x = enemy[1];
				if (board[y][x] == 1) {
					total -= 1;
					cnt += 1;
					board[y][x] = 0;
				}
			}

			total -= move(board);
		}

		answer = Math.max(answer, cnt);
	}

	private static int move(int[][] board) {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			cnt += board[n - 1][i];
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				board[i][j] = board[i - 1][j];
			}
		}

		for (int i = 0; i < m; i++) {
			board[0][i] = 0;
		}

		return cnt;
	}

	static private void kill(int y, int x, int[][] board, List<int[]> enemies) {
		int[][] visited = new int[n + 1][m];
		Queue<int[]> que = new ArrayDeque<>();
		visited[y][x] = 1;
		que.offer(new int[]{ y, x });

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			for (int i = 0; i < 3; i++) {
				int ny = curr[0] + dy[i];
				int nx = curr[1] + dx[i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m && visited[ny][nx] == 0 && visited[curr[0]][curr[1]] <= d) {
					if (board[ny][nx] == 1) {
						enemies.add(new int[]{ ny, nx });
						return;
					}
					visited[ny][nx] = visited[curr[0]][curr[1]] + 1;
					que.offer(new int[]{ ny, nx });
				}
			}
		}
	}

}