import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] switches;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		switches = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			if (g == 1) {
				for (int j = idx; j < n; j += idx + 1) {
					switches[j] = 1 - switches[j];
				}
			} else {
				int left = idx;
				int right = idx;
				while (0 <= left - 1 && right + 1 < n && switches[left - 1] == switches[right + 1]) {
					left--;
					right++;
				}

				for (int j = left; j < right + 1; j++) {
					switches[j] = 1 - switches[j];
				}
			}
		}

		for (int i = 0; i < switches.length; i++) {
			if (i != 0 && i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(switches[i]).append(" ");
		}

		System.out.println(sb);
	}

}