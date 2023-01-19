import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def go(y, x, d):
    cnt = 0

    while matrix[y + dy[d]][x + dx[d]] != "#" and matrix[y][x] != "O":
        y += dy[d]
        x += dx[d]
        cnt += 1

    return (y, x, cnt)


def bfs(ry, rx, by, bx):
    visited = [[[[0] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]
    visited[ry][rx][by][bx] = 1
    que = deque()
    que.append((ry, rx, by, bx))

    while que:
        ry, rx, by, bx = que.popleft()

        for i in range(4):
            nry, nrx, rcnt = go(ry, rx, i)
            nby, nbx, bcnt = go(by, bx, i)

            if matrix[nby][nbx] != "O":
                if matrix[nry][nrx] == "O":
                    return visited[ry][rx][by][bx]

                if nry == nby and nrx == nbx:
                    if rcnt < bcnt:
                        nby -= dy[i]
                        nbx -= dx[i]
                    else:
                        nry -= dy[i]
                        nrx -= dx[i]

                if visited[nry][nrx][nby][nbx] == 0:
                    visited[nry][nrx][nby][nbx] = visited[ry][rx][by][bx] + 1
                    que.append((nry, nrx, nby, nbx))

    return -1


n, m = map(int, input().split())
matrix = [list(input().strip()) for _ in range(n)]

ry, rx, by, bx = 0, 0, 0, 0

for i in range(n):
    for j in range(m):
        if matrix[i][j] == "R":
            ry, rx = i, j
            matrix[i][j] = "."
        elif matrix[i][j] == "B":
            by, bx = i, j
            matrix[i][j] = "."

answer = bfs(ry, rx, by, bx)

print(answer)
