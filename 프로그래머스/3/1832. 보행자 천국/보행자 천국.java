class Solution {
    
    int MOD = 20170805;
    int m, n;
    int[][][] dist;
    
    public int solution(int m, int n, int[][] cityMap) {
        this.m = m;
        this.n = n;
        dist = new int[m + 1][n + 1][2];
        
        dist[0][0][0] = 1;
        
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (cityMap[y][x] == 0) {
                    dist[y + 1][x][1] = (dist[y + 1][x][0] + dist[y][x][0] + dist[y][x][1]) % MOD;
                    dist[y][x + 1][0] = (dist[y][x + 1][0] + dist[y][x][0] + dist[y][x][1]) % MOD;
                } else if (cityMap[y][x] == 2) {
                    dist[y + 1][x][1] = (dist[y + 1][x][1] + dist[y][x][1]) % MOD;
                    dist[y][x + 1][0] = (dist[y][x + 1][0] + dist[y][x][0]) % MOD;
                }
            }
            
        }
       
        return (dist[m - 1][n - 1][0] + dist[m - 1][n - 1][1]) % MOD;
    }
}