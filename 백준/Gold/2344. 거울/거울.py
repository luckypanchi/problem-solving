import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


mirror = [3, 2, 1, 0]


n, m = map(int, input().split())
board = (
    [[0] * (m + 2)]
    + [[0] + list(map(int, input().split())) + [0] for _ in range(n)]
    + [[0] * (m + 2)]
)

info_board = [[0] * (m + 2) for _ in range(n + 2)]

idx = 1
for i in range(1, n + 1):
    info_board[i][0] = (idx, 0)
    idx += 1

for i in range(1, m + 1):
    info_board[-1][i] = (idx, 3)
    idx += 1

for i in range(n, 0, -1):
    info_board[i][-1] = (idx, 2)
    idx += 1

for i in range(m, 0, -1):
    info_board[0][i] = (idx, 1)
    idx += 1


answers = [0] * (2 * n + 2 * m + 1)

for i in range(n + 2):
    for j in range(m + 2):
        if info_board[i][j] != 0:
            idx, d = info_board[i][j]

            if answers[idx] != 0:
                continue

            y = i + dy[d]
            x = j + dx[d]
            while 0 < y < n + 1 and 0 < x < m + 1:
                if board[y][x] == 1:
                    d = mirror[d]

                y += dy[d]
                x += dx[d]

            dest = info_board[y][x][0]
            answers[idx] = dest
            answers[dest] = idx


print(*answers[1:])
