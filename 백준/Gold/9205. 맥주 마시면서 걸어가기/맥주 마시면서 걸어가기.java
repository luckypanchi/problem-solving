import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int n;
	static Pair home, dest;
	static Pair[] stores;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < tcs; tc++) {
			n = Integer.parseInt(br.readLine());
			stores = new Pair[n];
			st = new StringTokenizer(br.readLine());
			home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				stores[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			dest = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			solve();
		}

		System.out.println(sb);
	}

	private static void solve() {
		Deque<Pair> que = new ArrayDeque<>();
		visited = new boolean[n];
		que.add(home);

		while (!que.isEmpty()) {
			Pair curr = que.poll();

			if (dist(curr, dest) <= 1000) {
				sb.append("happy").append("\n");
				return;
			}

			for (int i = 0; i < n; i++) {
				if (!visited[i] && dist(curr, stores[i]) <= 1000) {
					visited[i] = true;
					que.add(stores[i]);
				}
			}
		}

		sb.append("sad").append("\n");
	}

	private static int dist(Pair pair1, Pair pair2) {
		return Math.abs(pair1.y - pair2.y) + Math.abs(pair1.x - pair2.x);
	}
	
	static class Pair {

		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}