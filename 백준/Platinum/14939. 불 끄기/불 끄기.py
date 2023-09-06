import sys

input = sys.stdin.readline
INF = float("inf")

dx = (1, 0, -1, 0, 0)
dy = (0, 1, 0, -1, 0)


def convert(s):
    return s == "O"


def check_range(y, x):
    return 0 <= y < 10 and 0 <= x < 10


board = [list(map(convert, input().strip())) for _ in range(10)]
answer = INF

for first_row in range(1 << 10):
    curr_board = []
    for i in range(10):
        curr_board.append(board[i][:])

    count = 0

    for col in range(10):
        if first_row & (1 << col):
            count += 1
            for i in range(5):
                nx = col + dx[i]
                ny = dy[i]
                if check_range(ny, nx):
                    curr_board[ny][nx] = not curr_board[ny][nx]

    for y in range(1, 10):
        for x in range(10):
            if curr_board[y - 1][x]:
                count += 1
                for i in range(5):
                    ny = y + dy[i]
                    nx = x + dx[i]
                    if check_range(ny, nx):
                        curr_board[ny][nx] = not curr_board[ny][nx]

    flag = True
    for col in range(10):
        if curr_board[9][col]:
            flag = False
            break

    if flag:
        answer = min(answer, count)


if answer == INF:
    answer = -1

print(answer)