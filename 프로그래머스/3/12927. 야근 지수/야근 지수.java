import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                int left = pq.poll();
                if (left - 1 != 0) {
                    pq.offer(left - 1);
                }
            }
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int left = pq.poll();
            answer += left * left;
        }
        
        return answer;
    }
}