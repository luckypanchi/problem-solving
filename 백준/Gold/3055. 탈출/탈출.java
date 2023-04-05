import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static char[][] board;
	static int[][] dist;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		dist = new int[r][c];

		Deque<Pair> waterQue = new ArrayDeque<>();
		Deque<Pair> posQue = new ArrayDeque<>();

		for (int i = 0; i < r; i++) {
			String row = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = row.charAt(j);

				if (board[i][j] == 'S') {
					posQue.add(new Pair(i, j));
					dist[i][j] = 1;
					board[i][j] = '.';
				} else if (board[i][j] == '*') {
					waterQue.add(new Pair(i, j));
				}
			}
		}

		while (!waterQue.isEmpty() || !posQue.isEmpty()) {
			int wQueSize = waterQue.size();
			for (int t = 0; t < wQueSize; t++) {
				Pair wCurr = waterQue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = wCurr.y + dy[i];
					int nx = wCurr.x + dx[i];
					if (0 <= ny && ny < r && 0 <= nx && nx < c && board[ny][nx] == '.') {
						board[ny][nx] = '*';
						waterQue.add(new Pair(ny, nx));
					}
				}
			}

			int pQueSize = posQue.size();
			for (int t = 0; t < pQueSize; t++) {
				Pair currPos = posQue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = currPos.y + dy[i];
					int nx = currPos.x + dx[i];
					if (0 <= ny && ny < r && 0 <= nx && nx < c && dist[ny][nx] == 0) {
						if (board[ny][nx] == '.') {
							dist[ny][nx] = dist[currPos.y][currPos.x] + 1;
							posQue.add(new Pair(ny, nx));
						} else if (board[ny][nx] == 'D') {
							System.out.println(dist[currPos.y][currPos.x]);
							System.exit(0);
						}
					}
				}
			}

		}

		System.out.println("KAKTUS");

	}


	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}