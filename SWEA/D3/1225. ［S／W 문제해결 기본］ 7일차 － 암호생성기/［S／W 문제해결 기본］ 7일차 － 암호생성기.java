import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> que;

		for (int tc = 1; tc < 11; tc++) {

			br.readLine();
			sb.append("#").append(tc).append(" ");

			que = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}

Loop:
			while (true) {
				for (int i = 1; i < 6; i++) {
					int num = que.poll();
					que.offer(Math.max(num - i, 0));
					if (num - i <= 0) {
						break Loop;
					}
				}
			}

			while (!que.isEmpty()) {
				sb.append(que.poll()).append(" ");
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

}