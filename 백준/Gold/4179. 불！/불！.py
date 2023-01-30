import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


r, c = map(int, input().split())
matrix = [list(input().strip()) for _ in range(r)]

start = None
fires = []
for i in range(r):
    for j in range(c):
        if matrix[i][j] == "J":
            start = (i, j)
        elif matrix[i][j] == "F":
            fires.append((i, j))


def bfs():
    que = deque()
    que.append(start)
    for f in fires:
        que.append(f)

    visited = [[0] *  c for _ in range(r)]

    while que:
        y, x = que.popleft()
        node = matrix[y][x]

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if node == "J":
                if 0 <= ny < r and 0 <= nx < c:
                    if matrix[ny][nx] == ".":
                        matrix[ny][nx] = node
                        visited[ny][nx] = visited[y][x] + 1
                        que.append((ny, nx))
                else:
                    print(visited[y][x] + 1)
                    sys.exit()
            elif node == "F":
                if 0 <= ny < r and 0 <= nx < c:
                    if matrix[ny][nx] == "." or matrix[ny][nx] == "J":
                        matrix[ny][nx] = node
                        visited[ny][nx] = 0
                        que.append((ny, nx))

    print("IMPOSSIBLE")

bfs()