import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] board;
	static int[] selected;
	static List<int[]> chickens, houses;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		selected = new int[m];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					houses.add(new int[]{ i, j });
				} else if (board[i][j] == 2) {
					chickens.add(new int[]{ i, j });
				}
			}
		}

		comb(0, 0);

		System.out.println(answer);

	}

	private static void comb(int cnt, int start) {
		if (cnt == m) {
			int total = 0;
			for (int[] house : houses) {
				int min = Integer.MAX_VALUE;
				for (int index : selected) {
					int[] chicken = chickens.get(index);
					int tmp = Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]);
					min = Math.min(min, tmp);
				}
				total += min;
			}

			answer = Math.min(answer, total);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}