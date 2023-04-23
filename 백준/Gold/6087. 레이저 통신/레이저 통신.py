import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs():
    dist = [[-1] * w for _ in range(h)]
    que = deque()

    dist[start_y][start_x] = 0
    que.append((start_y, start_x))

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            while 0 <= ny < h and 0 <= nx < w and board[ny][nx] == ".":
                if dist[ny][nx] == -1:
                    dist[ny][nx] = dist[y][x] + 1
                    que.append((ny, nx))

                if (ny, nx) == (dest_y, dest_x):
                    return dist[ny][nx]

                ny += dy[i]
                nx += dx[i]


w, h = map(int, input().split())
board = [list(input().strip()) for _ in range(h)]

start_y, start_x, dest_y, dest_x = -1, -1, -1, -1

for i in range(h):
    for j in range(w):
        if board[i][j] == "C":
            board[i][j] = "."
            if (start_y, start_x) == (-1, -1):
                start_y, start_x = i, j
            else:
                dest_y, dest_x = i, j


answer = bfs() - 1
print(answer)