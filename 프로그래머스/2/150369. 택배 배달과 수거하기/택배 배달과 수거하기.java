class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int remainDelivery = 0;
        int remainPickup = 0;
        
        for (int i = n - 1; i > -1; i--) {
            remainDelivery -= deliveries[i];
            remainPickup -= pickups[i];
            
            while (remainDelivery < 0 || remainPickup < 0) {
                remainDelivery += cap;
                remainPickup += cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}