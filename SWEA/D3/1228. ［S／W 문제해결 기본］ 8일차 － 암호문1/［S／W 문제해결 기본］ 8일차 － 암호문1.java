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
			int[] array = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int cnt = 0;

			while (cnt < m) {
				if (st.nextToken().equals("I")) {
					cnt++;
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int[] numbers = new int[y];
					for (int i = 0; i < y; i++) {
						numbers[i] = Integer.parseInt(st.nextToken());
					}

					int[] tmp = new int[array.length];
					System.arraycopy(array, 0, tmp, 0, array.length);

					array = new int[array.length + y];
					System.arraycopy(tmp, 0, array, 0, x);
					System.arraycopy(numbers, 0, array, x, y);
					System.arraycopy(tmp, x, array, x + y, tmp.length - x);
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(array[i]).append(" ");
			}

			sb.append("\n");

		}

		System.out.println(sb);
	}

}