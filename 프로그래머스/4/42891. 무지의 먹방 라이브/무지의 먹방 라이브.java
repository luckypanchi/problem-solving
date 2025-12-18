import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
       	if (getTotalSum(food_times) <= k) {
            return -1;
        }
        
       	PriorityQueue<Food> pq = new PriorityQueue<>((o1, o2) -> o1.timeCost - o2.timeCost);
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }
        
        long prevTimeCost = 0;
        while (!pq.isEmpty() && (long) (pq.peek().timeCost - prevTimeCost) * pq.size() <= k) {
            long size = pq.size();
            Food food = pq.poll();
            k -= ((long) food.timeCost - prevTimeCost) * size;
            prevTimeCost = food.timeCost;
        }
        
        List<Food> foodList = new ArrayList(pq);
        Collections.sort(foodList, (o1, o2) -> o1.number - o2.number);
        
        return foodList.get((int) (k % foodList.size())).number;
    }
    
    private long getTotalSum(int[] array) {
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }
    
    private class Food {
        int number;
        int timeCost;
        
        public Food(int number, int timeCost) {
            this.number = number;
            this.timeCost = timeCost;
        }
    }
}