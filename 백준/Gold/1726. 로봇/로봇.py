import sys
from collections import deque

input = sys.stdin.readline

dx = (1, -1, 0, 0)
dy = (0, 0, 1, -1)


def turn(d):
    if d == 0 or d == 1:
        return [2, 3]
    if d == 2 or d == 3:
        return [0, 1]


def bfs():
    que = deque()
    visited = [[[-1] * 4 for _ in range(m)] for _ in range(n)]

    que.append((startY, startX, startDir))
    visited[startY][startX][startDir] = 0

    while que:
        y, x, d = que.popleft()

        for nd in turn(d):
            nd %= 4
            if visited[y][x][nd] == -1:
                visited[y][x][nd] = visited[y][x][d] + 1
                que.append((y, x, nd))

        for k in range(1, 4):
            ny = y + k * dy[d]
            nx = x + k * dx[d]
            if 0 <= ny < n and 0 <= nx < m and visited[ny][nx][d] == -1:
                if board[ny][nx] == 1:
                    break

                visited[ny][nx][d] = visited[y][x][d] + 1
                que.append((ny, nx, d))

    return visited[destY][destX][destDir]


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
startY, startX, startDir = map(lambda x: x - 1, map(int, input().split()))
destY, destX, destDir = map(lambda x: x - 1, map(int, input().split()))


print(bfs())