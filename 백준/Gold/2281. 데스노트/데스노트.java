import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] names;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        names = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dfs(0);

        System.out.println(dp[0]);

    }

    private static int dfs(int start) {
        if (start == n) {
            return 0;
        }

        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }

        int remain = m - names[start];

        for (int end = start + 1; end <= n && remain >= 0; end++) {
            if (end == n) {
                dp[start] = 0;
                break;
            }

            dp[start] = Math.min(dp[start], remain * remain + dfs(end));
            remain -= 1 + names[end];
        }

        return dp[start];

    }
}