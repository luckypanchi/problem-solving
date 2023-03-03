import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		boolean flag = false;
		Queue<Pair> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					queue.offer(new Pair(i, j));
				}
				if (board[i][j] == 0) {
					flag = true;
				}
			}
		}

		if (!flag) {
			System.out.println(0);
			System.exit(0);
		}

		int answer = -1;
		while (!queue.isEmpty()) {
			int length = queue.size();
			for (int t = 0; t < length; t++) {
				Pair curr = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = curr.y + dy[i];
					int nx = curr.x + dx[i];
					if (0 <= ny && ny < n && 0 <= nx && nx < m && board[ny][nx] == 0) {
						board[ny][nx] = 1;
						queue.offer(new Pair(ny, nx));
					}
				}
			}
			answer += 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}

		System.out.println(answer);

	}

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}