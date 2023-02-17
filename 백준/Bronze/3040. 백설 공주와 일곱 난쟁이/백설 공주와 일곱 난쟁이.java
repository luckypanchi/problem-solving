import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] numbers, selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[9];
		selected = new int[7];
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0);

	}

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			int total = 0;
			for (int num : selected) {
				total += num;
			}
			if (total == 100) {
				for (int num : selected) {
					System.out.println(num);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			selected[cnt] = numbers[i];
			comb(cnt + 1, i + 1);
		}
	}

}