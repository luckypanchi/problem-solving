import sys

input = sys.stdin.readline

STAR = "*"


def draw(y, x, h):
    if h == 3:
        board[y][x] = STAR
        for dx in [-1, 1]:
            board[y + 1][x + dx] = STAR
        for dx in [-2, -1, 0, 1, 2]:
            board[y + 2][x + dx] = STAR
        return

    next_h = h // 2
    draw(y, x, next_h)
    draw(y + next_h, x - next_h, next_h)
    draw(y + next_h, x + next_h, next_h)


n = int(input())

board = [[" "] * 2 * n for _ in range(n)]

draw(0, n - 1, n)

for row in board:
    print("".join(row))