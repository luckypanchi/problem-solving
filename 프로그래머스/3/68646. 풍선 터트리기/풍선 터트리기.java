import java.util.*;

class Solution {
    
    public int solution(int[] a) {
        int length = a.length;
        int[] leftMin = new int[length];
        int[] rightMin = new int[length];
        
        leftMin[0] = a[0];
        for (int i = 1; i < length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        rightMin[length - 1] = a[length - 1];
        for (int i = length - 2; i > -1; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}