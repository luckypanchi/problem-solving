import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (0 < n) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n -= 1;
                ans += 1;
            }
        }

        return ans;
    }
}