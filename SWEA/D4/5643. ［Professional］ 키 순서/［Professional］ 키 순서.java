import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
	static int[] counts;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");

			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			counts = new int[n + 1];
			graph = new int[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}

			for (int k = 1; k < n + 1; k++) {
				for (int i = 1; i < n + 1; i++) {
					for (int j = 1; j < n + 1; j++) {
						if (graph[i][j] == 1 || (graph[i][k] == 1 && graph[k][j] == 1)) {
							graph[i][j] = 1;
						}
					}
				}
			}

			int answer = 0;
			for (int i = 1; i < n + 1; i++) {
				int result = 0;
				for (int j = 1; j < n + 1; j++) {
					result += graph[i][j] + graph[j][i];
				}

				if (result == n - 1) {
					answer++;
				}
			}

			sb.append(answer).append("\n");

		}

		System.out.println(sb);
	}

}