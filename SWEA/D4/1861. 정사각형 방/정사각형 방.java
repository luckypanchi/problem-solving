import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

	int y;
	int x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution {

	static int n;
	static int[][] board;
	static int[][] visited;
	static int answer;
	static int maxCnt;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			maxCnt = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					bfs(new Node(i, j));
				}
			}

			sb.append(answer).append(" ").append(maxCnt).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(Node node) {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(node);
		visited = new int[n][n];
		visited[node.y][node.x] = 1;

		while (!que.isEmpty()) {
			Node nd = que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = nd.y + dy[i];
				int nx = nd.x + dx[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[ny][nx] == 0 && board[ny][nx] == board[nd.y][nd.x] + 1) {
					visited[ny][nx] = visited[nd.y][nd.x] + 1;
					que.offer(new Node(ny, nx));
					if (maxCnt < visited[ny][nx]) {
						answer = board[node.y][node.x];
						maxCnt = visited[ny][nx];
					} else if (maxCnt == visited[ny][nx]) {
						answer = Math.min(answer, board[node.y][node.x]);
					}
				}
			}
		}

	}

}