import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

INF = float("inf")


def mark(y, x, m):
    que = deque()
    que.append((y, x))
    board[y][x] = m

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < n and board[ny][nx] == 1:
                que.append((ny, nx))
                board[ny][nx] = m


def go(y, x, m):
    que = deque()
    dist = [[0] * n for _ in range(n)]

    que.append((y, x))
    dist[y][x] = 1

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < n and dist[ny][nx] == 0 and board[ny][nx] != m:
                dist[ny][nx] = dist[y][x] + 1
                if board[ny][nx] != 0:
                    return dist[ny][nx] - 1
                else:
                    que.append((ny, nx))

    return INF


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

m = 2
for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            mark(i, j, m)
            m += 1

answer = INF

started = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if board[i][j] != 0:
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < n and 0 <= nx < n and board[ny][nx] == 0 and not started[ny][nx]:
                    result = go(ny, nx, board[i][j])
                    answer = min(answer, result)
                    started[ny][nx] = True

print(answer)