import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int[][] board;
	static StringBuilder sb;
	static List<Pair> empty;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		board = new int[9][9];
		empty = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String row = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = row.charAt(j) - '0';
				if (board[i][j] == 0) {
					empty.add(new Pair(i, j));
				}
			}
		}
		
		recursive(0);
	}

	private static void recursive(int idx) {
		if (idx == empty.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}

		Pair curr = empty.get(idx);
		boolean[] flags = check(curr.y, curr.x);
		for (int i = 1; i < 10; i++) {
			if (!flags[i]) {
				board[curr.y][curr.x] = i;
				recursive(idx + 1);
				board[curr.y][curr.x] = 0;
			}
		}
	}

	private static boolean[] check(int y, int x) {
		//가로, 세로, 대각선 2, 3x3 격자
		boolean[] flags = new boolean[10];

		for (int i = 0; i < 9; i++) {
			flags[board[y][i]] = true;
			flags[board[i][x]] = true;
		}

		int startY = (y / 3) * 3;
		int startX = (x / 3) * 3;
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				flags[board[i][j]] = true;
			}
		}

		return flags;
	}

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}
}