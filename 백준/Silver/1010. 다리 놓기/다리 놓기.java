import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		pascal();
		
		int tcs = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < tcs; tc ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int answer = dp[m][n];
			
			System.out.println(answer);
			
		}
		
	}

	private static void pascal() {
		dp = new int[31][31];
		for (int n = 0; n < 31; n ++) {
			for (int r = 0; r < 31; r ++) {
				if (n == r) {
					dp[n][r] = 1;
					break;
				} else if (r == 0) {
					dp[n][r] = 1;
				} else {
					dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
				}
	
			}
			
		}
	}

}