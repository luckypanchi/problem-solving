import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def bfs(startY, startX):
    visited = [[False] * m for _ in range(n)]
    visited[startY][startX] = True

    que = deque()
    que.append((startY, startX, 0))

    answer = -1

    while que:
        y, x, dist = que.popleft()

        answer = max(answer, dist)

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx] and board[ny][nx] == "L":
                visited[ny][nx] = True
                que.append((ny, nx, dist + 1))

    return dist


n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

answer = -1
for startY in range(n):
    for startX in range(m):
        if board[startY][startX] == "L":
            answer = max(answer, bfs(startY, startX))

print(answer)