import sys
from collections import deque

input = sys.stdin.readline


def rotate(board, t):
    length = int((n - 1) / 2)
    y, x = 0, 0
    while 0 < length:
        ny = [
            y,
            y,
            y,
            y + length,
            y + 2 * length,
            y + 2 * length,
            y + 2 * length,
            y + length,
        ]
        nx = [
            x,
            x + length,
            x + 2 * length,
            x + 2 * length,
            x + 2 * length,
            x + length,
            x,
            x,
        ]

        que = deque()

        for i in range(8):
            que.append(board[ny[i]][nx[i]])

        t %= 8
        que.rotate(t)

        for i in range(8):
            board[ny[i]][nx[i]] = que.popleft()

        length -= 1
        x += 1
        y += 1


tc = int(input())
for _ in range(tc):
    n, degree = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    rotate(board, degree // 45)

    for i in range(n):
        for j in range(n):
            print(board[i][j], end=" ")
        print()