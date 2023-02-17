import sys
from collections import deque

input = sys.stdin.readline
INF = int(1e9)

dz = (0, 0, 0, 0, 1, -1)
dy = (0, 1, 0, -1, 0, 0)
dx = (1, 0, -1, 0, 0, 0)


def bfs():
    global a, b, c
    que = deque([start])
    visited = [[[0] * a for _ in range(b)] for _ in range(c)]
    visited[start[0]][start[1]][start[2]] = 1

    while que:
        z, y, x = que.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if (
                0 <= nx < a
                and 0 <= ny < b
                and 0 <= nz < c
                and visited[nz][ny][nx] == 0
                and board[nz][ny][nx] != "#"
            ):
                visited[nz][ny][nx] = visited[z][y][x] + 1
                que.append((nz, ny, nx))
                if board[nz][ny][nx] == "E":
                    return visited[nz][ny][nx] - 1

    return INF


while True:
    c, b, a = map(int, input().split())
    if (c, b, a) == (0, 0, 0):
        break
    board = []
    start = None
    for k in range(c):
        board.append([list(input().strip()) for _ in range(b)])
        input()
        for i in range(b):
            for j in range(a):
                if board[k][i][j] == "S":
                    start = (k, i, j)

    result = bfs()

    if result == INF:
        print("Trapped!")
    else:
        print(f"Escaped in {result} minute(s).")