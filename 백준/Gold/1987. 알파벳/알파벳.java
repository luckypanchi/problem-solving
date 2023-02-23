import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static char[][] board;
	static int answer;
	static boolean[] visited;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			String row = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = row.charAt(j);
			}
		}

		answer = Integer.MIN_VALUE;
		visited = new boolean[26];
		visited[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(answer);
	}

	private static void dfs(int y, int x, int cnt) {
		answer = Math.max(answer, cnt);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < r && 0 <= nx && nx < c && !visited[board[ny][nx] - 'A']) {
				visited[board[ny][nx] - 'A'] = true;
				dfs(ny, nx, cnt + 1);
				visited[board[ny][nx] - 'A'] = false;
			}
		}
	}

}