import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
answer = [[-1] * m for _ in range(n)]

sy, sx = 0, 0
for i in range(n):
    for j in range(m):
        if matrix[i][j] == 2:
            sy, sx = i, j
        if matrix[i][j] == 0:
            answer[i][j] = 0

que = deque()
que.append((sy, sx))
answer[sy][sx] = 0
while que:
    y, x = que.popleft()
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and matrix[ny][nx] != 0 and answer[ny][nx] == -1:
            answer[ny][nx] = answer[y][x] + 1
            que.append((ny, nx))


for i in range(n):
    print(*answer[i])
