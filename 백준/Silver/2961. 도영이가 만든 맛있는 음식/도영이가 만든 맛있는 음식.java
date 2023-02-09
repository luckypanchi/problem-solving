import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] gradients;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		gradients = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			gradients[i][0] = Integer.parseInt(st.nextToken());
			gradients[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(new ArrayList<>(), 0);

		System.out.println(answer);
	}

	private static void subset(List<int[]> list, int cnt) {
		if (cnt == n) {
			if (!list.isEmpty()) {
				int t1 = 1; //신맛
				int t2 = 0; //쓴맛
				for (int[] gradient : list) {
					t1 *= gradient[0];
					t2 += gradient[1];
				}
				answer = Math.min(answer, Math.abs(t1 - t2));
			}
			return;
		}

		subset(list, cnt + 1);
		list.add(gradients[cnt]);
		subset(list, cnt + 1);
		list.remove(gradients[cnt]);
	}
}