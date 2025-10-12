class Solution {
    
    // d -> l -> r -> u
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {1, 0, 0, -1};
    private static String dir = "dlru";
    private static final String IMPOSSIBLE = "impossible";
    
    private static int n, m, r, c, k;
    private static String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (k < dist || k % 2 != dist % 2) {
            return IMPOSSIBLE;
        }
        
       	solve(x, y, "");
        
        return answer;
    }
    
    private boolean solve(int currY, int currX, String prev) {
        if (prev.length() == k) {
            if (isGoal(currY, currX)) {
                answer = prev;
                return true;
            }
            return false;
        }
        
        if (k - prev.length() < Math.abs(currY - r) + Math.abs(currX - c)) {
            return false;
        }
       
        for (int i = 0; i < 4; i++) {
            int ny = currY + dy[i];
            int nx = currX + dx[i];
           
            if (!checkRange(ny, nx)) {
                continue;
            }
           
            if (solve(ny, nx, prev + dir.charAt(i))) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isGoal(int y, int x) {
        return y == r && x == c;
    }
    
    private boolean checkRange(int y, int x) {
        return 1 <= y && y < n + 1 && 1 <= x && x < m + 1;
    }
    
}