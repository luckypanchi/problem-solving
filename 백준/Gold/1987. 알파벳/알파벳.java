import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, res_cnt;
	static int[] dx = { 0, 1, 0, -1 }; //우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };//우 하 좌 상
	static Character[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new Character[R][C];
		long alpha_idx = 1 << 27;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		alpha_idx |= (1 << (map[0][0] - 64));
		dfs(0, 0, alpha_idx, 1);
		System.out.println(res_cnt);
	}

	private static void dfs(int y, int x, long alpha_idx, int cnt) {

		for (int idx = 0; idx < 4; idx++) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && (alpha_idx & (1 << (map[nx][ny] - 64))) == 0) {
				dfs(ny, nx, alpha_idx | 1 << (map[nx][ny] - 64), cnt + 1);
			}
		}

		res_cnt = Math.max(cnt, res_cnt);
	}
}