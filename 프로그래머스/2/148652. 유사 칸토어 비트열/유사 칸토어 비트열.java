class Solution {
    static String s = "11011";

    public int solution(int n, long l, long r) {
        int answer = dfs(n, r) - dfs(n, l - 1);
        return answer;
    }

    private static int dfs(int n, long k) {
        int count = 0;

        if (n == 1) {
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            return count;
        }

        long a = k / (long) Math.pow(5, n - 1);
        long b = k % (long) Math.pow(5, n - 1);

        if (a <= 1) {
            count = (int) (Math.pow(4, n - 1) * a + dfs(n - 1, b));
        } else if (a == 2) {
            count = (int) (2 * Math.pow(4, n - 1));
        } else {
            count = (int) (Math.pow(4, n - 1) * (a - 1) + dfs(n - 1, b));
        }

        return count;
    }
}