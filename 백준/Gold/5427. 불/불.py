import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs():
    sque = deque()
    sque.append(start)
    fque = deque(fires)

    visited = [[0] * c for _ in range(r)]
    visited[start[0]][start[1]] = 1

    while sque or fque:
        length = len(fque)
        for _ in range(length):
            y, x = fque.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < r and 0 <= nx < c and board[ny][nx] == ".":
                    board[ny][nx] = "*"
                    fque.append((ny, nx))

        length = len(sque)
        for _ in range(length):
            y, x = sque.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < r and 0 <= nx < c:
                    if board[ny][nx] == "." and visited[ny][nx] == 0:
                        visited[ny][nx] = visited[y][x] + 1
                        sque.append((ny, nx))

                else:
                    print(visited[y][x])
                    return

    print("IMPOSSIBLE")



tc = int(input())
for _ in range(tc):
    c, r = map(int, input().split())
    board = [list(input().strip()) for _ in range(r)]

    start = None
    fires = []
    for i in range(r):
        for j in range(c):
            if board[i][j] == "@":
                board[i][j] = "."
                start = (i, j)
            if board[i][j] == "*":
                fires.append((i, j))

    bfs()