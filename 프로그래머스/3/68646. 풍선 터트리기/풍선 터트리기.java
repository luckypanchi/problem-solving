import java.util.*;

class Solution {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }
        if (a.length == 2) {
            return 2;
        }
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        leftMin[0] = a[0];
        rightMin[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        for (int i = a.length - 2; i > -1; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int answer = 2;
        for (int i = 1; i < a.length - 1; i++) {
            if (leftMin[i] >= a[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
       
        return answer;
    }
}