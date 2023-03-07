import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, answer;
	static int[][] results;
	static int[] players, base;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		results = new int[n][9];
		players = new int[9];
		isSelected = new boolean[9];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				results[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MIN_VALUE;
		choose(0);

		System.out.println(answer);
	}

	private static void choose(int cnt) {
		if (cnt == 9) {
			play();
			return;
		}

		if (cnt == 3) {
			players[cnt] = 0;
			choose(cnt + 1);
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				players[cnt] = i;
				choose(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	private static void play() {
		int hitterIdx = 0;
		int point = 0;
		int inning = 0;

		while (inning < n) {
			int outCount = 0;
			base = new int[4];
			while (outCount < 3) {
				int player = players[hitterIdx];
				int res = results[inning][player];

				if (res == 0) {
					outCount += 1;
				} else {
					point += hit(res);
				}

				hitterIdx = (hitterIdx + 1) % 9;
			}

			inning++;
		}

		answer = Math.max(answer, point);
	}

	private static int hit(int num) {
		int point = 0;
		int[] newBase = new int[4];
		switch (num) {
			case 1:
				point += base[3];
				newBase[3] = base[2];
				newBase[2] = base[1];
				newBase[1] = 1;
				break;
			case 2:
				point += base[2] + base[3];
				newBase[3] = base[1];
				newBase[2] = 1;
				break;
			case 3:
				point += base[1] + base[2] + base[3];
				newBase[3] = 1;
				break;
			case 4:
				point += base[1] + base[2] + base[3] + 1;
				break;
		}

		base = newBase;
		return point;
	}

}