import sys
from collections import deque

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())
    sy, sx = map(int, input().split())
    conv = [list(map(int, input().split())) for _ in range(n)]
    dest_y, dest_x = map(int, input().split())
    visited = [False] * n

    que = deque()
    que.append((sy, sx))
    while que:
        y, x = que.popleft()
        if abs(y - dest_y) + abs(x - dest_x) <= 1000:
            print("happy")
            break

        for i in range(n):
            if not visited[i]:
                ny, nx = conv[i]
                if abs(y - ny) + abs(x - nx) <= 1000:
                    que.append((ny, nx))
                    visited[i] = True
    else:
        print("sad")
        
