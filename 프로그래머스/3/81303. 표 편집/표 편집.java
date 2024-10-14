import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }
        left[0] = -1;
        right[n - 1] = -1;
        
        Stack<Integer> history = new Stack<>();
        boolean[] isDeleted = new boolean[n];
        int cursor = k;
        
        for(String command : cmd) {
            char op = command.charAt(0);
            if (op == 'U') {
                int count = Integer.valueOf(command.split(" ")[1]);
                for (int i = 0; i < count; i++) {
                    cursor = left[cursor];
                }
            } else if (op == 'D') {
                int count = Integer.valueOf(command.split(" ")[1]);
                for (int i = 0; i < count; i++) {
                    cursor = right[cursor];
                }
            } else if (op == 'C') {
                isDeleted[cursor] = true;
                history.push(cursor);
                if (left[cursor] != -1 && right[cursor] != -1) {
                    left[right[cursor]] = left[cursor];
                    right[left[cursor]] = right[cursor];
                } else if (left[cursor] == -1 && right[cursor] != -1) {
                	left[right[cursor]] = -1;
                } else if (left[cursor] != -1 && right[cursor] == -1) {
                   	right[left[cursor]] = -1;
                } 
                
                if (right[cursor] == -1) {
                    cursor = left[cursor];
                } else {
                    cursor = right[cursor];
                }
                
            } else if (op == 'Z') {
                int deleted = history.pop();
                isDeleted[deleted] = false;
                left[deleted] = -1;
                right[deleted] = -1;
                for (int i = deleted - 1; i >= 0; i--) {
                    if (!isDeleted[i]) {
                        left[deleted] = i;
                        right[i] = deleted;
                        break;
                    }
                }
                for (int i = deleted + 1; i < n; i++) {
                    if (!isDeleted[i]) {
                        right[deleted] = i;
                        left[i] = deleted;
                        break;
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isDeleted[i]) {
                answer.append('X');
            } else {
                answer.append('O');
            }
        }
        
        return answer.toString();
    }
}