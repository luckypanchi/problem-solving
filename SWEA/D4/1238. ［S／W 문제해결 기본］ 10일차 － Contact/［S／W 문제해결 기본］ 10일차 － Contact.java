import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int n, start;
	static boolean[][] matrix;
	static int maxCnt, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc < 11; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			matrix = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
			}

			maxCnt = Integer.MIN_VALUE;
			bfs(start);

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		queue.add(new int[]{ start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int node = tmp[0];
			int cnt = tmp[1];

			if (maxCnt < cnt) {
				maxCnt = cnt;
				answer = node;
			} else if (maxCnt == cnt) {
				answer = Math.max(answer, node);
			}

			for (int nextNode = 0; nextNode < 101; nextNode++) {
				if (matrix[node][nextNode] && !visited[nextNode]) {
					visited[nextNode] = true;
					queue.add(new int[]{ nextNode, cnt + 1 });
				}
			}
		}

	}

}