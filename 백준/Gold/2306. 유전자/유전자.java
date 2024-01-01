import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String code;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        code = br.readLine();
        dp = new int[code.length()][code.length()];

        for (int size = 1; size < code.length(); size++) {
            for (int start = 0; start + size < code.length(); start++) {
                int end = start + size;
                
                if ((code.charAt(start) == 'a' && code.charAt(end) == 't')
                        || code.charAt(start) == 'g' && code.charAt(end) == 'c') {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                }

                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.max(dp[start][end], dp[start][mid] + dp[mid + 1][end]);
                }
            }
        }

        int answer = dp[0][code.length() - 1];

        System.out.println(answer);

    }
}