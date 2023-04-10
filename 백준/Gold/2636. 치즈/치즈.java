import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, total;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				total += board[i][j];
			}
		}

		int time = 0;
		while (true) {
			time++;
			int melted = melt();
			if (total - melted == 0) {
				System.out.println(time);
				System.out.println(total);
				break;
			} else {
				total -= melted;
			}
		}
	}

	private static int melt() {
		Queue<Pair> que = new ArrayDeque<>();
		Queue<Pair> meltCandidates = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];

		que.add(new Pair(0, 0));
		visited[0][0] = true;

		while (!que.isEmpty()) {
			Pair curr = que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (board[ny][nx] == 0) {
						que.add(new Pair(ny, nx));
					} else {
						meltCandidates.add(new Pair(ny, nx));
					}
				}
			}
		}

		int size = meltCandidates.size();

		while (!meltCandidates.isEmpty()) {
			Pair curr = meltCandidates.poll();
			board[curr.y][curr.x] = 0;
		}
		return size;
	}

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}