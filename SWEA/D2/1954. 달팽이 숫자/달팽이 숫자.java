import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t < tc + 1; t++) {
			sb.append("#").append(t).append("\n");

			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];

			int y = 0;
			int x = 0;
			int d = 0;
			int num = 1;
			while (num < n * n + 1) {
				board[y][x] = num++;
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx] == 0) {
					y = ny;
					x = nx;
				} else {
					d = (d + 1) % 4;
					y = y + dy[d];
					x = x + dx[d];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}