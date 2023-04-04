import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, markNum;
	static int[][] board;
	static Map<Integer, List<Bridge>> graph;
	static boolean[] visited;
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
			}
		}

		mark();

		graph = new HashMap<>();
		for (int i = 2; i < markNum; i++) {
			graph.put(i, new ArrayList<>());
		}

		getAllBridges();

		int answer = prim();

		for (int i = 2; i < markNum; i++) {
			if (!visited[i]) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);

	}

	private static int prim() {
		PriorityQueue<Bridge> priorityQueue = new PriorityQueue<>();
		visited = new boolean[markNum];
		priorityQueue.add(new Bridge(0, 2));
		int answer = 0;

		while (!priorityQueue.isEmpty()) {
			Bridge curr = priorityQueue.poll();
			if (visited[curr.dest]) {
				continue;
			}
			visited[curr.dest] = true;
			answer += curr.w;
			for (Bridge nxt : graph.get(curr.dest)) {
				if (!visited[nxt.dest]) {
					priorityQueue.add(nxt);
				}
			}
		}

		return answer;
	}

	private static void getAllBridges() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (board[y][x] == 0) {
					for (int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if (0 <= ny && ny < n && 0 <= nx && nx < m && board[ny][nx] != 0) {
							checkBridge(y, x, board[ny][nx], (i + 2) % 4);
						}
					}
				}
			}
		}
	}

	private static void checkBridge(int y, int x, int markNum, int d) {
		int ny = y;
		int nx = x;
		int cnt = 0;
		while (0 <= ny + dy[d] && ny + dy[d] < n && 0 <= nx + dx[d] && nx + dx[d] < m && board[ny + dy[d]][nx + dx[d]] != markNum) {
			ny += dy[d];
			nx += dx[d];
			cnt++;
			if (board[ny][nx] != 0) {
				if (1 < cnt) {
					graph.get(markNum).add(new Bridge(cnt, board[ny][nx]));
				}
				break;
			}
		}
	}

	private static void mark() {
		markNum = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					bfs(i, j, markNum);
					markNum++;
				}
			}
		}
	}

	private static void bfs(int y, int x, int markNum) {
		Deque<Pair> que = new ArrayDeque<>();
		que.add(new Pair(y, x));
		board[y][x] = markNum;

		while (!que.isEmpty()) {
			Pair curr = que.poll();
			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];
				if (0 <= nx && nx < m && 0 <= ny && ny < n && board[ny][nx] == 1) {
					board[ny][nx] = markNum;
					que.add(new Pair(ny, nx));
				}
			}
		}
	}

	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Bridge implements Comparable<Bridge> {

		int w, dest;

		public Bridge(int w, int dest) {
			this.w = w;
			this.dest = dest;
		}

		@Override
		public int compareTo(Bridge other) {
			return this.w - other.w;
		}

	}

}