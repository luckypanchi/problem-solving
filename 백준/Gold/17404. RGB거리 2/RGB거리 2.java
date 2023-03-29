import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] costs;
	static int answer;
	static int INF = 1001 * 1001 + 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		costs = new int[n][3];
		answer = INF;
		for (int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 3; i ++) {
			int[][] dp = new int[n][3];
			for (int r = 0; r < n; r ++) {
				for (int c = 0; c < 3; c ++) {
					dp[r][c] = INF;
				}
			}
			
			dp[0][i] = costs[0][i];
			
			for (int t = 1; t < n; t ++) {
				dp[t][0] = costs[t][0] + Math.min(dp[t - 1][1], dp[t - 1][2]);
				dp[t][1] = costs[t][1] + Math.min(dp[t - 1][0], dp[t - 1][2]);
				dp[t][2] = costs[t][2] + Math.min(dp[t - 1][0], dp[t - 1][1]);
			}			
			
			for (int j = 0; j < 3; j ++) {
				if (i != j) {
					answer = Math.min(answer, dp[n - 1][j]);
				}
			}
			
		}
		
		System.out.println(answer);
			

	}

}