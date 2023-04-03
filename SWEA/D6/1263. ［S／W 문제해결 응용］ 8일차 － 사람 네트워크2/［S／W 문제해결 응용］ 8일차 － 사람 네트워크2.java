import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			board = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && board[i][j] == 0) {
						board[i][j] = 999999;
					}
				}
			}

			int answer = solve();
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static int solve() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 0; j < n; j++) {
					if (i == j || k == j) {
						continue;
					}
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += board[i][j];
			}
			answer = Math.min(answer, sum);
		}

		return answer;
	}

}