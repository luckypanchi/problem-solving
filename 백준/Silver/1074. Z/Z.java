import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int length = (int) Math.pow(2, n);

		solve(0, length, r, c);
	}

	private static void solve(int prev, int length, int sy, int sx) {
		if (length == 1) {
			System.out.println(prev);
			return;
		}
		int half = length / 2;
		int area = half * half;
		if (sx < half && sy < half) {
			solve(prev, half, sy, sx);
		} else if (half <= sx && sy < half) {
			solve(prev + area * 1, half, sy, sx - half);
		} else if (sx < half && half <= sy) {
			solve(prev + area * 2, half, sy - half, sx);
		} else {
			solve(prev + area * 3, half, sy - half, sx - half);
		}
	}

}