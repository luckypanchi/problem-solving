import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, currentOpen1, currentOpen2, doorCnt;
    static int[] doorList;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        currentOpen1 = Integer.parseInt(st.nextToken());
        currentOpen2 = Integer.parseInt(st.nextToken());
        doorCnt = Integer.parseInt(br.readLine());
        doorList = new int[doorCnt];

        for (int i = 0; i < doorCnt; i++) {
            doorList[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[doorCnt][n + 1][n + 1];
        for (int i = 0; i < doorCnt; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(dfs(0, currentOpen1, currentOpen2));
    }

    static private int dfs(int doorIndex, int open1, int open2) {
        if (doorIndex == doorCnt) {
            return 0;
        }

        if (dp[doorIndex][open1][open2] != -1) {
            return dp[doorIndex][open1][open2];
        }

        int current = doorList[doorIndex];
        int case1 = Math.abs(current - open1) + dfs(doorIndex + 1, current, open2);
        int case2 = Math.abs(current - open2) + dfs(doorIndex + 1, open1, current);
        dp[doorIndex][open1][open2] = Math.min(case1, case2);

        return dp[doorIndex][open1][open2];
    }
}