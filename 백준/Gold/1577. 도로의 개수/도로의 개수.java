import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int k;
    static long[][] dp;
    static boolean[][][] brokenRoad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        brokenRoad = new boolean[n + 1][m + 1][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == c) {
                if (b < d) {
                    brokenRoad[c][d][1] = true;
                } else {
                    brokenRoad[a][b][1] = true;
                }
            } else if (b == d) {
                if (a < c) {
                    brokenRoad[c][d][0] = true;
                } else {
                    brokenRoad[a][b][0] = true;
                }
            }

        }

        dp = new long[n + 1][m + 1];
        dp[0][0] = 1L;

        for (int x = 0; x < n + 1; x++) {
            for (int y = 0; y < m + 1; y++) {
                if (0 < x && !brokenRoad[x][y][0]) {
                    dp[x][y] += dp[x - 1][y];
                }
                if (0 < y && !brokenRoad[x][y][1]) {
                    dp[x][y] += dp[x][y - 1];
                }
            }
        }

        System.out.println(dp[n][m]);

    }

}