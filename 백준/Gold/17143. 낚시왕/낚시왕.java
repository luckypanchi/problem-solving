import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, m;
	static Shark[] sharks;
	static int[][] board;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		sharks = new Shark[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(y, x, s, d, z);
			board[y][x] = i + 1;
		}

		int answer = 0;
		for (int fishKing = 0; fishKing < c; fishKing++) {
			for (int i = 0; i < r; i++) {
				if (board[i][fishKing] != 0) {
					int sharkIdx = board[i][fishKing] - 1;
					answer += sharks[sharkIdx].size;
					sharks[sharkIdx] = null;
					board[i][fishKing] = 0;
					break;
				}
			}
			move();
		}

		System.out.println(answer);

	}

	private static void move() {
		int[][] newBoard = new int[r][c];
		for (int i = 0; i < m; i++) {
			Shark shark = sharks[i];
			if (shark == null) {
				continue;
			}

			int ny = shark.y;
			int nx = shark.x;
			for (int j = 0; j < shark.s; j++) {
				int nd = shark.d;
				if (!(0 <= ny + dy[nd] && ny + dy[nd] < r && 0 <= nx + dx[nd] && nx + dx[nd] < c)) {
					if (shark.d < 2) {
						shark.d = 1 - shark.d;
					} else {
						shark.d = 5 - shark.d;
					}
				}

				ny += dy[shark.d];
				nx += dx[shark.d];
			}

			shark.y = ny;
			shark.x = nx;

			if (newBoard[ny][nx] != 0) {
				int prevSharkIdx = newBoard[ny][nx] - 1;
				if (sharks[prevSharkIdx].size < shark.size) {
					newBoard[ny][nx] = i + 1;
					sharks[prevSharkIdx] = null;
				} else {
					sharks[i] = null;
				}
			} else {
				newBoard[ny][nx] = i + 1;
			}
		}
		board = newBoard;
	}

	static class Shark {

		int y, x, s, d, size;

		public Shark(int y, int x, int s, int d, int size) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.size = size;
		}
	}

}