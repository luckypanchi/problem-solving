import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[] dp;
    static final long MOD = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[10001];

        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i < n + 1; i += 2) {
            for (int j = 0; j < i - 1; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[n]);
    }
}