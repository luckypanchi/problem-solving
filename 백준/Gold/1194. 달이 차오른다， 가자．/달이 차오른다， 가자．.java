import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, startY, startX;
	static char[][] board;
	static int[][][] dist;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = row.charAt(j);

				if (board[i][j] == '0') {
					startY = i;
					startX = j;
					board[i][j] = '.';
				}
			}
		}

		List<Integer> result = bfs();

		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(Collections.min(result));
		}

	}

	private static List<Integer> bfs() {
		Queue<Pair> que = new ArrayDeque<>();
		dist = new int[1 << 6][n][m];
		que.add(new Pair(0, startY, startX));
		dist[0][startY][startX] = 1;
		List<Integer> results = new ArrayList<>();

		while (!que.isEmpty()) {
			Pair curr = que.poll();

			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];

				if (0 <= ny && ny < n && 0 <= nx && nx < m && board[ny][nx] != '#' && dist[curr.key][ny][nx] == 0) {
					if (board[ny][nx] == '1') {
						results.add(dist[curr.key][curr.y][curr.x]);
					} else if (board[ny][nx] == '.') {
						dist[curr.key][ny][nx] = dist[curr.key][curr.y][curr.x] + 1;
						que.add(new Pair(curr.key, ny, nx));
					} else if ('a' <= board[ny][nx] && board[ny][nx] <= 'f') {
						int newKey = curr.key | (1 << (board[ny][nx] - 'a'));
						dist[newKey][ny][nx] = dist[curr.key][curr.y][curr.x] + 1;
						que.add(new Pair(newKey, ny, nx));
					} else if ('A' <= board[ny][nx] && board[ny][nx] <= 'F' && hasKey(board[ny][nx], curr.key)) {
						dist[curr.key][ny][nx] = dist[curr.key][curr.y][curr.x] + 1;
						que.add(new Pair(curr.key, ny, nx));
					}

				}
			}

		}

		return results;
	}

	private static boolean hasKey(char door, int key) {
		return (key & (1 << (door - 'A'))) != 0;
	}

	static class Pair {

		int y, x, key;

		public Pair(int key, int y, int x) {
			this.y = y;
			this.x = x;
			this.key = key;
		}

	}

}