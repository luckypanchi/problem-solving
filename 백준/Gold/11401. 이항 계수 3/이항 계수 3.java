import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, r;
	static int MOD = 1000000007;
	static int LIMIT = 4000000;
	static long[] fac;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		init();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		long answer = fac[n] % MOD;
		answer *= fpow((fac[n - r] * fac[r]) % MOD, MOD - 2) % MOD;
		answer %= MOD;

		System.out.println(answer);

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