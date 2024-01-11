import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] positions;
    static long[] costSum;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        positions = new int[n + 1];
        costSum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = Integer.parseInt(st.nextToken());
            costSum[i] = costSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        dp = new long[n + 1][n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1L;
                }
            }
        }

        System.out.println(solve(m, m, 0));
    }

    private static long solve(int left, int right, int isLeft) {

        if (left == 1 && right == n) {
            return 0;
        }

        if (dp[left][right][isLeft] != -1) {
            return dp[left][right][isLeft];
        }

        int currPosition = isLeft == 0 ? left : right;
        long result = Long.MAX_VALUE;
        long lightCost = costSum[n] - costSum[right] + costSum[left - 1];
        if (1 < left) {
            result = solve(left - 1, right, 0) + (positions[currPosition] - positions[left - 1]) * lightCost;
        }
        if (right < n) {
            long tempResult = solve(left, right + 1, 1) + (positions[right + 1] - positions[currPosition]) * lightCost;
            result = Math.min(result, tempResult);
        }

        dp[left][right][isLeft] = result;
        return result;

    }
}