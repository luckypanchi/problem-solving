import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 1, 0, -1, -1, -1, 0, 1)
dy = (0, 1, 1, 1, 0, -1, -1, -1)


def bfs():
    que = deque(start)

    while que:
        y, x = que.popleft()
        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and dist[ny][nx] == 0:
                dist[ny][nx] = dist[y][x] + 1
                que.append((ny, nx))


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

start = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            start.append((i, j))

dist = [[0] * m for _ in range(n)]
for y, x in start:
    dist[y][x] = 1

bfs()

answer = 0
for i in range(n):
    for j in range(m):
        answer = max(answer, dist[i][j])

print(answer - 1)