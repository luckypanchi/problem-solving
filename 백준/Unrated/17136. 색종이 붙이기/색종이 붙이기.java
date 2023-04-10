import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] initBoard = new int[10][10];
		int[] initExisted = { 0, 5, 5, 5, 5, 5 };
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				initBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(initBoard, initExisted);

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		System.out.println(answer);

	}

	private static void solve(int[][] board, int[] existed) {
		int countBlanks = 0;

LOOP:
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (board[y][x] == 1) {
					for (int length = 1; length < 6; length++) {
						if (check(y, x, length, board) && 0 < existed[length]) {
							int[][] newBoard = copyBoard(board);
							int[] newExisted = copyExisted(existed);
							mark(y, x, length, newBoard);
							newExisted[length] -= 1;
							solve(newBoard, newExisted);
						}
					}
					break LOOP;
				} else {
					countBlanks++;
				}
			}
		}

		if (countBlanks == 10 * 10) {
			int sum = 0;
			for (int i : existed) {
				sum += i;
			}
			answer = Math.min(answer, 5 * 5 - sum);
		}
	}

	static int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	static int[] copyExisted(int[] existed) {
		int[] newExisted = new int[6];
		for (int i = 0; i < 6; i++) {
			newExisted[i] = existed[i];
		}
		return newExisted;
	}

	static void mark(int y, int x, int length, int[][] board) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				board[y + i][x + j] = 0;
			}
		}
	}

	static boolean check(int y, int x, int length, int[][] board) {
		if (10 <= y + length - 1 || 10 <= x + length - 1) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (board[y + i][x + j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}