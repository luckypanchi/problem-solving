import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] start, target;
    static int[][][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        start = new int[n];
        target = new int[n];

        String startTmp = br.readLine();
        String targetTmp = br.readLine();
        for (int i = 0; i < n; i++) {
            start[i] = startTmp.charAt(i) - '0';
            target[i] = targetTmp.charAt(i) - '0';
        }

        dp = new int[n][10][10][10][2];
        int answer = Math.min(solve(0, 0, 0, 0, 0),
                              solve(0, 0, 0, 0, 1));

        System.out.println(answer);
    }

    static private int solve(int currIndex, int a, int b, int c, int flag) {
        if (currIndex == n) {
            return 0;
        }

        if (dp[currIndex][a][b][c][flag] != 0) {
            return dp[currIndex][a][b][c][flag];
        }

        int _flag = flag == 1 ? 1 : -1;
        if (calc(start[currIndex] + a) == calc(target[currIndex])) {
            dp[currIndex][a][b][c][flag] = Math.min(solve(currIndex + 1, b, c, 0, 0),
                                                    solve(currIndex + 1, b, c, 0, 1));
            return dp[currIndex][a][b][c][flag];
        }

        int result = Integer.MAX_VALUE - 1;
        dp[currIndex][a][b][c][flag] = result;
        for (int i = 1; i < 4; i++) {
            result = Math.min(result, 1 + solve(currIndex, calc(a + i * _flag), b, c, flag));
            result = Math.min(result, 1 + solve(currIndex, calc(a + i * _flag), calc(b + i * _flag), c, flag));
            result = Math.min(result, 1 + solve(currIndex, calc(a + i * _flag), calc(b + i * _flag), calc(c + i * _flag), flag));
        }
        dp[currIndex][a][b][c][flag] = result;
        return dp[currIndex][a][b][c][flag];
    }

    static private int calc(int number) {
        while (number < 0) {
            number += 10;
        }
        return number % 10;
    }
}