import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
       
        int length = p.length();
        long pivot = Long.parseLong(p);
        
        for (int i = 0; i < t.length() - length + 1; i ++) {
            long number = Long.parseLong(t.substring(i, i + length));
            if (number <= pivot) {
                answer ++;
            }
        }
        
        return answer;
    }
}