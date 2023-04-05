import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, len, answer;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			answer = 0;
			board = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				boolean flag = true;
				boolean[][] visited = new boolean[n][n];
				for (int j = 0; j < n - 1; j++) {
					if (checkRow(visited, i, j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer++;
				}
			}

			for (int j = 0; j < n; j++) {
				boolean flag = true;
				boolean[][] visited = new boolean[n][n];
				for (int i = 0; i < n - 1; i++) {
					if (checkCol(visited, i, j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);

	}

	private static boolean checkRow(boolean[][] visited, int i, int j) {
		return (board[i][j] + 1 == board[i][j + 1] && !check(visited, i, j + 1, 2))
			|| (board[i][j] - 1 == board[i][j + 1] && !check(visited, i, j, 0))
			|| (1 < Math.abs(board[i][j] - board[i][j + 1]));
	}

	private static boolean checkCol(boolean[][] visited, int i, int j) {
		return (board[i][j] + 1 == board[i + 1][j] && !check(visited, i + 1, j, 3))
			|| (board[i][j] - 1 == board[i + 1][j] && !check(visited, i, j, 1))
			|| (1 < Math.abs(board[i][j] - board[i + 1][j]));
	}

	private static boolean check(boolean[][] visited, int y, int x, int d) {
		int h = board[y][x] - 1;

		int ny = y;
		int nx = x;
		for (int i = 0; i < len; i++) {
			int tmpY = ny + dy[d];
			int tmpX = nx + dx[d];
			if (0 <= tmpY && tmpY < n && 0 <= tmpX && tmpX < n && board[tmpY][tmpX] == h && !visited[tmpY][tmpX]) {
				ny += dy[d];
				nx += dx[d];
			} else {
				return false;
			}
		}

		ny = y;
		nx = x;
		for (int i = 0; i < len; i++) {
			ny += dy[d];
			nx += dx[d];
			visited[ny][nx] = true;
		}

		return true;
	}

}