import sys
from collections import deque

input = sys.stdin.readline

INF = float("inf")
dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, m, t = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dist = [[-1] * m for _ in range(n)]
dist[0][0] = 0

answer = INF

que = deque([(0, 0)])
while que:
    y, x = que.popleft()

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m and dist[ny][nx] == -1 and board[ny][nx] != 1:
            dist[ny][nx] = dist[y][x] + 1
            que.append((ny, nx))
            if board[ny][nx] == 2:
                answer = dist[ny][nx] + abs(ny - n + 1) + abs(nx - m + 1)


if dist[n - 1][m - 1] != -1:
    answer = min(answer, dist[n - 1][m - 1])

if t < answer or answer == -1:
    print("Fail")
else:
    print(answer)