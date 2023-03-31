import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();
		StringTokenizer st;
		
		int tcs = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < tcs + 1; tc++) {
			sBuilder.append("#").append(tc).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[n];
			
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (numbers[j] < numbers[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
			}
			
			int answer = 0;
			for (int i = 0; i < n; i++) {
				answer = Math.max(answer, dp[i]);
			}
			
			sBuilder.append(answer).append("\n");
		}
		
		System.out.println(sBuilder);

	}


}