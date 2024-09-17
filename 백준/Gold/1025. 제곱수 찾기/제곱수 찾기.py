import sys

input = sys.stdin.readline


def make_number(sy, sx, dy, dx):
    if dy == 0 and dx == 0:
        return board[sy][sx] if board[sy][sx] ** 0.5 % 1 == 0 else -1

    selected = []
    y = sy
    x = sx
    while 0 <= y < n and 0 <= x < m:
        selected.append(str(board[y][x]))
        y += dy
        x += dx

    result = -1
    number = ""
    for i in range(len(selected)):
        number += selected[i]
        if (int(number) ** 0.5) % 1 == 0:
            result = max(result, int(number))
    return result


n, m = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

answer = -1
for row_gap in range(-n + 1, n):
    for col_gap in range(-m + 1, m):
        for row_start in range(n):
            for col_start in range(m):
                curr = make_number(row_start, col_start, row_gap, col_gap)
                answer = max(answer, curr)


print(answer)