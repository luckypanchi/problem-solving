class Solution {
    
    static int n, answer;
    static int[] info;
    static int[][] edges;
    static boolean[] visited;
    
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        this.info = info;
        this.edges = edges;
        visited = new boolean[n];
        
        answer = 0;
        visited[0] = true;
        dfs(1, 0);
        
        return answer;
    }
    
    private void dfs(int sheepCount, int wolfCount) {
        answer = Math.max(answer, sheepCount);
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (visited[parent] && !visited[child]) {
                if (info[child] == 0) {
                    visited[child] = true;
                    dfs(sheepCount + 1, wolfCount);
                    visited[child] = false;
                } else if (wolfCount + 1 < sheepCount) {
                    visited[child] = true;
                    dfs(sheepCount, wolfCount + 1);
                    visited[child] = false;
                }
            }
        }
    }
}