import java.util.*;

class Solution {
    
   	int[][] info;
    int maxA, maxB;
    int[][][] dp;
    
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        maxA = n;
        maxB = m;
        
        dp = new int[info.length][maxA][maxB];
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < maxA; j++) {
            	Arrays.fill(dp[i][j], -1);
            }
        }
        
        int result = dfs(0, 0, 0);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dfs(int curr, int prevA, int prevB)  {
        if (curr == info.length) {
            return prevA;
        }
        if (dp[curr][prevA][prevB] != -1) {
            return dp[curr][prevA][prevB];
        }
        
        int result = Integer.MAX_VALUE;
        if (info[curr][0] + prevA < maxA) {
            result = Math.min(result, dfs(curr + 1, prevA + info[curr][0], prevB));
        }
        if (info[curr][1] + prevB < maxB) {
            result = Math.min(result, dfs(curr + 1, prevA, prevB + info[curr][1]));
        }
        
        dp[curr][prevA][prevB] = result;
        
        return result;
    }
}