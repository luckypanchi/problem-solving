import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        for (int currTime = 0; currTime < 24; currTime++) {
            int needed = players[currTime] / m;
            if (needed <= servers[currTime]) {
                continue;
            }
            int addCount = needed - servers[currTime];
            answer += addCount;
            for (int i = currTime; i < Math.min(currTime + k, 24); i++) {
                servers[i] += addCount;
            }
        }
        
        return answer;
    }
}