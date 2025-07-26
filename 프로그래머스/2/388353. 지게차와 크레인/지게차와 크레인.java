import java.util.*;

class Solution {
    
    int n, m;
    char[][] board;
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        board = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                board[i][j] = '1';
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                board[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for (int i = 0; i < requests.length; i++) {
            int type = requests[i].length();
            char target = requests[i].charAt(0);
           	if (type == 1) {
                typeOne(target);
            } else if (type == 2) {
                typeTwo(target);
            }
            markSide();
        }
        
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (board[i][j] != '1' && board[i][j] != '2') {
                    answer++;
                }
            }
        }
       
        return answer;
    }
    
    private void typeOne(char target) {
        char[][] newBoard = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (checkSide(i, j) && board[i][j] == target) {
                    newBoard[i][j] = '1';
                }
            }
        }
        
        board = newBoard;
    }
    
    private void typeTwo(char target) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (board[i][j] == target) {
                	board[i][j] = '2';
                }
            }
        }
    }
    
    private void markSide() {
        Deque<int[]> que = new ArrayDeque<>();
        
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (board[i][j] == '1') {
                    que.offer(new int[]{i, j});
                }
            }
        }
        
        while (!que.isEmpty()) {
            int[] curr = que.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                
                if (!checkRange(ny, nx)) {
                    continue;
                }
                
                if (board[ny][nx] == '2') {
                    que.offer(new int[]{ny, nx});
                    board[ny][nx] = '1';
                }
            }
        }
        
    }
    
    private boolean checkSide(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (board[ny][nx] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkRange(int y, int x) {
        return 0 <= y && y < n + 2 && 0 <= x && x < m + 2;
    }
}