import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new int[n + 1][n + 1];
		int[][][] dp = new int[n + 1][n + 1][3];
		dp[1][2][1] = 1;
		
		for (int i = 1; i < n + 1; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j ++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if (board[i][j] == 0) {
					dp[i][j][0] += dp[i - 1][j][0] + dp[i - 1][j][2];
					dp[i][j][1] += dp[i][j - 1][1] + dp[i][j - 1][2];
					if (board[i][j - 1] == 0 && board[i - 1][j] == 0) {
						dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
				}
			}
		}

		System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
				
	}

}