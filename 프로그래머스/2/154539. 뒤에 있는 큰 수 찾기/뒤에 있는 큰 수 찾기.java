import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        Arrays.fill(answer, -1);
       	
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(0);
        
        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty()) {
                int prevIndex = stack.pollLast();
                if (numbers[prevIndex] < numbers[i]) {
                    answer[prevIndex] = numbers[i];
                } else {
                    stack.offerLast(prevIndex);
                    break;
                }
            }
           	stack.offerLast(i);
        }
        
        return answer;
    }
}