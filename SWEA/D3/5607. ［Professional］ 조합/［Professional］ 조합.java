import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, r;
	static int MOD = 1234567891;
	static int LIMIT = 1000001;
	static long[] fac;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tcs = Integer.parseInt(br.readLine());
		init();

		for (int tc = 1; tc < tcs + 1; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			long answer = fac[n] % MOD;
			answer *= fpow((fac[n - r] * fac[r]) % MOD, MOD - 2) % MOD;
			answer %= MOD;
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void init() {
		fac = new long[LIMIT];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i < LIMIT; i++) {
			fac[i] = (i * fac[i - 1]) % MOD;
		}
	}

	private static long fpow(long number, int t) {
		if (t == 1) {
			return number;
		}

		long result = fpow(number, t / 2) % MOD;
		if (t % 2 == 0) {
			return (result * result) % MOD;
		} else {
			return ((result * result) % MOD * number) % MOD;
		}
	}

}