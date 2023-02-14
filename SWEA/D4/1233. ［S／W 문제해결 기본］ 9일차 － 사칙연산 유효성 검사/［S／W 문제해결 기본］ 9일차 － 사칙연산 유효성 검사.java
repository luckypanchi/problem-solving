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

			int n = Integer.parseInt(br.readLine());
			String[] nodes = new String[n + 1];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				nodes[idx] = st.nextToken();
			}

			int result = 1;
			for (int i = 1; i < n + 1; i++) {
				if (2 * i < n) {
					if (isInteger(nodes[i])) {
						result = 0;
						break;
					}
				} else {
					if (!isInteger(nodes[i])) {
						result = 0;
						break;
					}
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}