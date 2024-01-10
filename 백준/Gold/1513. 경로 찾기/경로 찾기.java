import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000007;
    static int n, m, c;
    static int[][][][] dp;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][m + 1][c + 1][c + 1];
        dp[1][1][0][0] = 1;

        board = new int[n + 1][m + 1];
        for (int arcadeNum = 1; arcadeNum < c + 1; arcadeNum++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 1 && y == 1) {
                dp[1][1][0][0] = 0;
                dp[1][1][arcadeNum][1] = 1;
            }
            board[x][y] = arcadeNum;
        }

        for (int y = 1; y < n + 1; y++) {
            for (int x = 1; x < m + 1; x++) {
                if (y == 1 && x == 1) {
                    continue;
                }

                if (board[y][x] > 0) {
                    int currArcadeNum = board[y][x];
                    for (int maxArcadeNum = 0; maxArcadeNum < currArcadeNum; maxArcadeNum++) {
                        for (int i = 0; i < maxArcadeNum + 1; i++) {
                            dp[y][x][currArcadeNum][i + 1] += dp[y - 1][x][maxArcadeNum][i] + dp[y][x - 1][maxArcadeNum][i];
                            dp[y][x][currArcadeNum][i + 1] %= MOD;
                        }
                    }
                } else {
                    for (int maxArcadeNum = 0; maxArcadeNum < c + 1; maxArcadeNum++) {
                        for (int i = 0; i < maxArcadeNum + 1; i++) {
                            dp[y][x][maxArcadeNum][i] += dp[y - 1][x][maxArcadeNum][i] + dp[y][x - 1][maxArcadeNum][i];
                            dp[y][x][maxArcadeNum][i] %= MOD;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < c + 1; i++) {
            int sum = 0;
            for (int j = 0; j < c + 1; j++) {
                sum += dp[n][m][j][i];
                sum %= MOD;
            }
            sb.append(sum).append(" ");
        }

        System.out.println(sb);
    }
}