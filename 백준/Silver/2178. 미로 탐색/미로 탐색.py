import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, m = map(int, input().split())
matrix = [list(map(int, list(input().rstrip()))) for _ in range(n)]


que = deque()
que.append((0, 0))
dist = [[0] * m for _ in range(n)]
dist[0][0] = 1

while que:
    y, x = que.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < m and 0 <= ny < n and matrix[ny][nx] == 1:
            matrix[ny][nx] = 0
            que.append((ny, nx))
            dist[ny][nx] = dist[y][x] + 1
            if nx == m - 1 and ny == n - 1:
                print(dist[ny][nx])
                sys.exit()
