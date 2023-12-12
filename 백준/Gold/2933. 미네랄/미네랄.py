import sys
from collections import deque


input = sys.stdin.readline
INF = float("inf")


dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def throw(round, y):
    if round % 2 == 0:
        steps = range(c)
    else:
        steps = range(c - 1, -1, -1)

    for x in steps:
        if board[y][x] == "x":
            board[y][x] = "."
            check(y, x)
            break


def check(y, x):
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < r and 0 <= nx < c and board[ny][nx] == "x":
            drop(ny, nx)


def drop(y, x):
    que = deque()
    visited = [[False] * c for _ in range(r)]

    que.append((y, x))
    visited[y][x] = True

    clusters = [(y, x)]
    bottoms = [-INF] * c
    bottoms[x] = y

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < r and 0 <= nx < c and not visited[ny][nx] and board[ny][nx] == "x":
                visited[ny][nx] = True
                que.append((ny, nx))
                clusters.append((ny, nx))
                bottoms[nx] = max(bottoms[nx], ny)

    length = INF
    for x in range(c):
        y = bottoms[x]
        if y == -INF:
            continue

        tmpLength = 0
        while True:
            if y + 1 == r or board[y + 1][x] == "x":
                break

            y += 1
            tmpLength += 1

        length = min(length, tmpLength)

    for y, x in clusters:
        board[y][x] = "."

    for y, x in clusters:
        board[y + length][x] = "x"


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]

n = int(input())
heights = list(map(int, input().split()))
for round in range(n):
    throw(round, r - heights[round])

for row in board:
    print("".join(row))