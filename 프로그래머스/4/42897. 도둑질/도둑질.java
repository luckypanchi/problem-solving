class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dpO = new int[n]; // 첫번째 집 포함 O
        int[] dpX = new int[n]; // 첫번째 집 포함 X
        
        dpO[0] = money[0]; // 첫번째 집 포함 O
        dpO[1] = money[0];
        
        dpX[0] = 0; // 첫번째 집 포함 X
        dpX[1] = money[1];
        
        for (int i = 2; i < n; i++) {
            dpO[i] = Math.max(dpO[i - 1], dpO[i - 2] + money[i]);
            dpX[i] = Math.max(dpX[i - 1], dpX[i - 2] + money[i]);
        }
        
        int answer = Math.max(dpO[n - 2], dpX[n - 1]);
        return answer;
    }
}