import java.util.*;

class Solution {
    
    static int[] diffs;
    static int[] times;
    static int n;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.n = diffs.length;
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (calcTime(mid) <= limit) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private long calcTime(int level) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            int currDiff = diffs[i];
           	int currTime = times[i];
            
            if (currDiff <= level) {
                result += currTime;
            } else {
                result += (times[i - 1] + currTime) * (currDiff - level) + currTime;
            }
        }
        
        return result;
    }
}