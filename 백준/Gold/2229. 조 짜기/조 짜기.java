import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        scores = new int[n];
        dp = new int[n];
        Arrays.fill(dp, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(dp[0]);

    }

    private static int dfs(int prev, int start) {
        if (start == n) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        for (int end = start; end < n; end++) {
            int score = getScore(start, end);
            int nextMax = dfs(prev + score, end + 1);
            dp[start] = Math.max(dp[start], score + nextMax);
        }

        return dp[start];
    }

    private static int getScore(int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end + 1; i++) {
            min = Math.min(min, scores[i]);
            max = Math.max(max, scores[i]);
        }

        return max - min;
    }
}