import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            int size = tangerine[i];
            if (map.containsKey(size)) {
                map.put(size, map.get(size) + 1);
            } else {
            	map.put(size, 1);
            }
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int key : map.keySet()) {
            heap.add(map.get(key));
        }
        
        int count = 0;
        int answer = 0;
        while (count < k) {
            int curr = heap.poll();
            count += curr;
            answer++;
        }
        
        return answer;
    }
}