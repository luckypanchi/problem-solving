import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(3, n + 1)];
        dp[2] = 1L;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        System.out.println(dp[n]);
    }
}