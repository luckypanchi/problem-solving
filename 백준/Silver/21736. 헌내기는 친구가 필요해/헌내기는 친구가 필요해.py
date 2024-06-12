import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

startY = 0
startX = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == "I":
            startY = i
            startX = j

que = deque()
visited = [[False] * m for _ in range(n)]
answer = 0

que.append((startY, startX))
visited[startY][startX] = True

while que:
    y, x = que.popleft()

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and board[ny][nx] != "X" and not visited[ny][nx]:
            visited[ny][nx] = True
            que.append((ny, nx))
            if board[ny][nx] == "P":
                answer += 1

if answer == 0:
    answer = "TT"

print(answer)