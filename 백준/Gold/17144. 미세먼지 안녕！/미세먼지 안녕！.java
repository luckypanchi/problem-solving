import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, t;
	static int[][] board, newBoard;
	static int[] purifierYs;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		purifierYs = new int[2];
		int idx = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					purifierYs[idx] = i;
					idx++;
				}
			}
		}

		for (int k = 0; k < t; k++) {
			spreadAll();
			purify();
		}

		int answer = 2;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				answer += board[i][j];
			}
		}

		System.out.println(answer);
	}

	private static void spreadAll() {
		newBoard = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (0 < board[i][j]) {
					spread(i, j);
				}
			}
		}

		for (int i = 0; i < 2; i++) {
			newBoard[purifierYs[i]][0] = -1;
		}
		board = newBoard;
	}

	private static void spread(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < r && 0 <= nx && nx < c && board[ny][nx] != -1) {
				cnt += 1;
				newBoard[ny][nx] += board[y][x] / 5;
			}
		}
		newBoard[y][x] += board[y][x] - (board[y][x] / 5) * cnt;
	}

	private static void purify() {
		purifyUpper(purifierYs[0]);
		purifyLower(purifierYs[1]);
	}

	private static void purifyLower(int purifierY) {
		for (int i = purifierY + 1; i < r - 1; i++) {
			board[i][0] = board[i + 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			board[r - 1][i] = board[r - 1][i + 1];
		}

		for (int i = r - 1; i > purifierY; i--) {
			board[i][c - 1] = board[i - 1][c - 1];
		}

		for (int i = c - 1; i > 1; i--) {
			board[purifierY][i] = board[purifierY][i - 1];
		}

		board[purifierY][1] = 0;
	}

	private static void purifyUpper(int purifierY) {
		for (int i = purifierY - 1; i > 0; i--) {
			board[i][0] = board[i - 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			board[0][i] = board[0][i + 1];
		}

		for (int i = 0; i < purifierY; i++) {
			board[i][c - 1] = board[i + 1][c - 1];
		}

		for (int i = c - 1; i > 1; i--) {
			board[purifierY][i] = board[purifierY][i - 1];
		}

		board[purifierY][1] = 0;
	}
}