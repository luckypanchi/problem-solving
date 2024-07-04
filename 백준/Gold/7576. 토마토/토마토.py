import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

visited = [[-1] * m for _ in range(n)]
que = deque()

cnt = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            visited[i][j] = 0
            que.append((i, j))
        elif board[i][j] == -1:
            cnt += 1

answer = 0
while que:
    y, x = que.popleft()

    answer = max(answer, visited[y][x])
    cnt += 1

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and board[ny][nx] == 0 and visited[ny][nx] == -1:
            visited[ny][nx] = visited[y][x] + 1
            que.append((ny, nx))

if cnt != n * m:
    answer = -1

print(answer)