import sys
from collections import deque

def main():
    n, k = map(int, sys.stdin.readline().split())
    
    que = deque()
    que.append((n, 0))
    MAX = 100001
    visited = [0]*MAX
    while que:
        p, cnt = que.popleft()
        visited[p] = 1                                            # 횟수를 어디서 카운트할 것인가
        if p == k:
            answer = cnt   
            break
        
        if 0<=p-1<MAX and visited[p-1] == 0: 
            que.append((p-1, cnt+1))
        if 0<=p+1<MAX and visited[p+1] == 0: 
            que.append((p+1, cnt+1))
        if 0<=2*p<MAX and visited[2*p] == 0: 
            que.append((2*p, cnt+1))
    
    print(answer)
if __name__ == "__main__":
    main()