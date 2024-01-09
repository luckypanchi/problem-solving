import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int startY, startX;
    static int[][] positions;
    static long[][] dp;
    static int[] dy = { 0, 0, 1, 0, -1 };
    static int[] dx = { 0, 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        positions = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i][0] = Integer.parseInt(st.nextToken());
            positions[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new long[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        long answer = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            int nextX = positions[0][0] + dx[i];
            int nextY = positions[0][1] + dy[i];

            if (!check(nextY, nextX)) {
                continue;
            }

            int dist = Math.abs(startY - nextY) + Math.abs(startX - nextX);
            answer = Math.min(answer, dist + dfs(0, i));
        }

        System.out.println(answer);

    }

    private static long dfs(int currNode, int pos) {
        if (currNode == n - 1) {
            return 0;
        }

        if (dp[currNode][pos] != Long.MAX_VALUE) {
            return dp[currNode][pos];
        }

        int currX = positions[currNode][0] + dx[pos];
        int currY = positions[currNode][1] + dy[pos];
        int nextNode = currNode + 1;
        long minDist = Long.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            int nextX = positions[nextNode][0] + dx[i];
            int nextY = positions[nextNode][1] + dy[i];

            if (!check(nextY, nextX)) {
                continue;
            }

            int dist = Math.abs(currY - nextY) + Math.abs(currX - nextX);
            minDist = Math.min(minDist, dist + dfs(nextNode, i));

        }

        dp[currNode][pos] = minDist;
        return dp[currNode][pos];

    }

    private static boolean check(int y, int x) {
        return 0 <= y && y < 100001 && 0 <= x && x < 100001;
    }
}