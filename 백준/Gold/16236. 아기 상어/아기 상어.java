import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, babySize, eatCnt, currY, currX;
	static int[][] board;
	static int[] fishCnt;
	static int answer;

	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		fishCnt = new int[7];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					currY = i;
					currX = j;
					board[i][j] = 0;
				} else if (board[i][j] != 0) {
					fishCnt[board[i][j]] += 1;
				}
			}
		}

		babySize = 2;
		eatCnt = 0;
		solve();

		System.out.println(answer);
	}

	private static void solve() {
		while (check() && findAndEat()) {
			if (eatCnt == babySize) {
				babySize++;
				eatCnt = 0;
			}
		}
	}

	private static boolean findAndEat() {
		Queue<Node> queue = new ArrayDeque<>();
		int[][] visited = new int[n][n];
		queue.offer(new Node(currY, currX));
		visited[currY][currX] = 1;

		PriorityQueue<Node> found = new PriorityQueue<>();

		while (!queue.isEmpty()) {
			int length = queue.size();
			boolean flag = false;
			for (int t = 0; t < length; t++) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y + dy[i];
					int nx = node.x + dx[i];
					if (0 <= ny && ny < n && 0 <= nx && nx < n && visited[ny][nx] == 0 && board[ny][nx] <= babySize) {
						queue.offer(new Node(ny, nx));
						visited[ny][nx] = visited[node.y][node.x] + 1;
						if (0 < board[ny][nx] && board[ny][nx] < babySize) {
							found.offer(new Node(ny, nx));
							flag = true;
						}
					}
				}
			}
			if (flag) {
				break;
			}
		}
		
		if (!found.isEmpty()) {
			Node node = found.poll();
			eatCnt++;
			fishCnt[board[node.y][node.x]] -= 1;
			board[node.y][node.x] = 0;
			currY = node.y;
			currX = node.x;
			answer += visited[node.y][node.x] - 1;
			return true;
		} else {
			return false;
		}
	}

	private static boolean check() {
		int remaining = 0;
		for (int i = 1; i < Math.min(babySize, 7); i++) {
			remaining += fishCnt[i];
		}
		return remaining != 0;
	}

	static class Node implements Comparable<Node> {

		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Node other) {
			if (this.y != other.y) {
				return this.y - other.y;
			}
			return this.x - other.x;
		}
	}
}