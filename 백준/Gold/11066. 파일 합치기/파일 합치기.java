import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tcs, k;
    static int[] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tcs = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < tcs; tc++) {
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            cost = new int[k + 1];
            for (int i = 1; i < k + 1; i++) {
                cost[i] = cost[i - 1] + Integer.parseInt(st.nextToken());
            }

            dp = new int[k + 1][k + 1];
            for (int length = 1; length < k + 1; length++) {
                for (int start = 1; start < k - length + 1; start++) {
                    int end = start + length;
                    dp[start][end] = getMinCost(start, end, length) + (cost[end] - cost[start - 1]);
                }
            }

            sb.append(dp[1][k]).append("\n");
        }

        System.out.println(sb);
    }

    private static int getMinCost(int start, int end, int length) {
        int result = Integer.MAX_VALUE;
        for (int mid = 0; mid < length; mid++) {
            result = Math.min(result, dp[start][start + mid] + dp[start + mid + 1][end]);
        }
        return result;
    }
}