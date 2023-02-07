import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int n, m;
	static int[] numbers;
	static int[] result;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		result = new int[m];
		isSelected = new boolean[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = i + 1;
		}

		perm(0);

		System.out.println(sb);

	}

	private static void perm(int currIdx) {
		if (currIdx == m) {
			for (int num : result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				result[currIdx] = numbers[i];
				perm(currIdx + 1);
				isSelected[i] = false;
			}
		}
	}

}