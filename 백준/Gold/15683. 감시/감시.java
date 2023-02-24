import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] initBoard;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<Node> nodes;
	static int answer;
	static int[][][] map = {
		{},
		{
			{ 0 }, { 1 }, { 2 }, { 3 }
		},
		{
			{ 0, 2 },
			{ 1, 3 },
		},
		{
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 0 },
		},
		{
			{ 0, 1, 2 },
			{ 1, 2, 3 },
			{ 2, 3, 0 },
			{ 3, 0, 1 },
		},
		{
			{ 0, 1, 2, 3 }
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		initBoard = new int[n][m];
		nodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				initBoard[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= initBoard[i][j] && initBoard[i][j] < 6) {
					nodes.add(new Node(initBoard[i][j], i, j));
				}
			}
		}

		answer = Integer.MAX_VALUE;
		solve(0, initBoard);

		System.out.println(answer);
	}

	private static void solve(int idx, int[][] board) {
		if (idx == nodes.size()) {
			answer = Math.min(answer, count(board));
			return;
		}

		Node node = nodes.get(idx);
		int[][] dirs = map[node.camera];
		for (int i = 0; i < dirs.length; i++) {
			int[][] newBoard = copyBoard(board);
			for (int j = 0; j < dirs[i].length; j++) {
				check(node.y, node.x, dirs[i][j], newBoard);
			}
			solve(idx + 1, newBoard);
		}
	}

	private static int count(int[][] board) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void check(int y, int x, int d, int[][] board) {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];

			if (0 <= nx && nx < m && 0 <= ny && ny < n && board[ny][nx] != 6) {
				if (board[ny][nx] == 0) {
					board[ny][nx] = -1;
				}
			} else {
				break;
			}
		}

	}

	private static int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	static class Node {

		int camera;
		int y, x;

		public Node(int camera, int y, int x) {
			this.camera = camera;
			this.y = y;
			this.x = x;
		}
	}

}