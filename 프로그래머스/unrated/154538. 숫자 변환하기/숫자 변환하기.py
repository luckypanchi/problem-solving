from collections import deque


def bfs(start, dest, n):
    visited = set()
    que = deque()
    
    visited.add(start)
    que.append((start, 0))
    
    while que:
        curr, cnt = que.popleft()
        
        if curr == dest:
            return cnt
        
        for _next in [curr + n, curr * 2, curr * 3]:
            if 1 <= _next < dest + 1 and _next not in visited:
                visited.add(_next)
                que.append((_next, cnt + 1))
                
    return -1


def solution(x, y, n):
    answer = bfs(x, y, n)
    return answer