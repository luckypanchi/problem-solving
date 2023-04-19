import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 1, 0, -1, -1, -1, 0, 1, 0)
dy = (0, 1, 1, 1, 0, -1, -1, -1, 0)


def bfs():
    sy, sx = 7, 0
    dest_y, dest_x = 0, 7

    que = deque()
    que.append((sy, sx))

    while True:
        visited = [[False] * 8 for _ in range(8)]

        length = len(que)

        if length == 0:
            break

        for _ in range(length):
            y, x = que.popleft()

            if board[y][x] == "#":
                continue

            for i in range(9):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < 8 and 0 <= nx < 8 and board[ny][nx] == "." and not visited[ny][nx]:
                    visited[ny][nx] = True
                    que.append((ny, nx))

                    if (ny, nx) == (dest_y, dest_x):
                        return 1

        for i in range(7, 0, -1):
            board[i] = board[i - 1]
        board[0] = ["."] * 8

    return 0


board = [list(input().strip()) for _ in range(8)]

print(bfs())