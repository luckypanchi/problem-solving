import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][][] dp;
    static int sqrt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = (int) Math.pow(2, 15);
        sqrt = (int) Math.sqrt(n);
        dp = new int[n + 1][sqrt + 1][5];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sqrt + 1; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        solve(n, 1, 0);

        while (true) {
            n = Integer.parseInt(br.readLine());
            sqrt = (int) Math.sqrt(n);
            if (n == 0) {
                break;
            }

            sb.append(solve(n, 1, 0)).append("\n");
        }


        System.out.println(sb);
    }

    private static int solve(int curr, int prev, int count) {
        if (curr < 0 || 4 < count || sqrt < prev) {
            return 0;
        }

        if (curr == 0) {
            return 1;
        }

        if (dp[curr][prev][count] != -1) {
            return dp[curr][prev][count];
        }

        int result = 0;
        result += solve(curr, prev + 1, count);
        result += solve(curr - prev * prev, prev, count + 1);

        dp[curr][prev][count] = result;
        return result;
    }
}