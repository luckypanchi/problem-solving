import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;
    static String s1, s2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        s1 = br.readLine();
        s2 = br.readLine();

        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        System.out.println(solve(0, 0));

    }

    private static int solve(int index1, int index2) {
        if (index1 == s1.length() && index2 == s2.length()) {
            return 0;
        }

        if (dp[index1][index2] != Integer.MIN_VALUE) {
            return dp[index1][index2];
        }

        int result = Integer.MIN_VALUE;

        if (index1 < s1.length()) {
            result = b + solve(index1 + 1, index2);
        }

        if (index2 < s2.length()) {
            result = Math.max(result, b + solve(index1, index2 + 1));
        }

        if (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                result = Math.max(result, a + solve(index1 + 1, index2 + 1));
            } else {
                result = Math.max(result, c + solve(index1 + 1, index2 + 1));
            }
        }

        dp[index1][index2] = result;
        return result;

    }
}