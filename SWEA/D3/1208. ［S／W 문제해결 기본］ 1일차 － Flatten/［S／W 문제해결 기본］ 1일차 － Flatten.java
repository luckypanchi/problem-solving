import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc < 11; tc++) {
			sb.append("#").append(tc).append(" ");

			int[] heights = new int[101];

			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				heights[idx]++;
			}

			for (int t = 0; t < n; t++) {
				int maxH = getMaxH(heights);
				int minH = getMinH(heights);
				if (minH + 1 == maxH || minH == maxH) {
					break;
				}
				heights[maxH]--;
				heights[maxH - 1]++;
				heights[minH]--;
				heights[minH + 1]++;
			}

			int maxH = getMaxH(heights);
			int minH = getMinH(heights);

			sb.append(maxH - minH).append("\n");

		}

		System.out.println(sb);

	}

	private static int getMinH(int[] heights) {
		int minH = 0;
		for (int i = 0; i < 101; i++) {
			if (heights[i] > 0) {
				minH = i;
				break;
			}
		}
		return minH;
	}

	private static int getMaxH(int[] heights) {
		int maxH = 0;
		for (int i = 100; i > -1; i--) {
			if (heights[i] > 0) {
				maxH = i;
				break;
			}
		}
		return maxH;
	}

}