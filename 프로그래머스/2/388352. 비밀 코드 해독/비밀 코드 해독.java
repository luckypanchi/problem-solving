import java.util.*;

class Solution {
    
    int[] selected;
    int answer = 0;
    int n;
    int[][] q;
    int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        selected = new int[5];
       	this.n = n;
        this.q = q;
        this.ans = ans;
        
        comb(0, 1);
        
        return answer;
    }
    
    private void comb(int curr, int start) {
        if (curr == 5) {
            if (check()) {
                answer++;
            }
            return;
        }
        
        for (int i = start; i < n + 1; i++) {
            selected[curr] = i;
            comb(curr + 1, i + 1);
        }
    }
    
    private boolean check() {
        for (int i = 0; i < q.length; i++) {
            if (count(i) != ans[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int count(int index) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (q[index][i] == selected[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}