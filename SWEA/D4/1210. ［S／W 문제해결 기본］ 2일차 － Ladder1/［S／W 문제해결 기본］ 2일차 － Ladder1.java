import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

	int y, x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution {

	static int[][] matrix;
	static int[] dy = { 0, 0, -1 };
	static int[] dx = { 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc < 11; tc++) {
			sb.append("#").append(tc).append(" ");
			matrix = new int[100][100];
			br.readLine();
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (matrix[99][i] == 2) {
					sb.append(go(i));
					break;
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static int go(int x) {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(99, x));
		boolean[][] visited = new boolean[100][100];
		visited[99][x] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			//좌우로 움직일 수 있으면 위로 올라가면 안됨
			int length = 3;
			for (int i = 0; i < 2; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (0 <= ny && ny < 100 && 0 <= nx && nx < 100 && !visited[ny][nx] && matrix[ny][nx] != 0) {
					length = 2;
				}
			}

			for (int i = 0; i < length; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				if (0 <= ny && ny < 100 && 0 <= nx && nx < 100 && !visited[ny][nx] && matrix[ny][nx] == 1) {
					if (ny == 0) {
						return nx;
					}
					visited[ny][nx] = true;
					que.add(new Node(ny, nx));
				}
			}
		}

		return 100;
	}

}