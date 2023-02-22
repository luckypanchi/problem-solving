import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n;
	static Pair company, house;
	static Pair[] customers;
	static int[] selected;
	static boolean[] isSelected;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			customers = new Pair[n];
			selected = new int[n];
			isSelected = new boolean[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n + 2; i++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (i == 0) {
					company = new Pair(y, x);
				} else if (i == 1) {
					house = new Pair(y, x);
				} else {
					customers[i - 2] = new Pair(y, x);
				}
			}

			answer = Integer.MAX_VALUE;
			perm(0);
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == n) {
			int dist = 0;
			int y = company.y;
			int x = company.x;
			for (int i = 0; i < n; i++) {
				int idx = selected[i];
				dist += Math.abs(y - customers[idx].y) + Math.abs(x - customers[idx].x);
				y = customers[idx].y;
				x = customers[idx].x;
			}
			dist += Math.abs(y - house.y) + Math.abs(x - house.x);

			answer = Math.min(answer, dist);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selected[cnt] = i;
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

}