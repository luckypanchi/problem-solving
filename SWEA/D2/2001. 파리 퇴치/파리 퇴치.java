import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] board = new int[n + 1][n + 1];
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					int input = Integer.parseInt(st.nextToken());
					board[i][j] = input + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
				}
			}

			int answer = Integer.MIN_VALUE;
			for (int i = m; i < n + 1; i++) {
				for (int j = m; j < n + 1; j++) {
					answer = Math.max(answer, board[i][j] - board[i - m][j] - board[i][j - m] + board[i - m][j - m]);
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}