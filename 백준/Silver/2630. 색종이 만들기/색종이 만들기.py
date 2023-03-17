import sys

input = sys.stdin.readline


def check(y, x, length):
    white_cnt, blue_cnt = 0, 0
    for i in range(y, y + length):
        for j in range(x, x + length):
            if board[i][j] == 0:
                white_cnt += 1
            else:
                blue_cnt += 1

    if white_cnt == length * length:
        return 1
    elif blue_cnt == length * length:
        return 2
    else:
        return 0


def solve(y, x, length):
    global white, blue

    result = 0
    check_res = check(y, x, length)

    if check_res == 1:
        white += 1
    elif check_res == 2:
        blue += 1
    else:
        next_length = length // 2
        result += (
            solve(y, x, next_length)
            + solve(y + next_length, x, next_length)
            + solve(y, x + next_length, next_length)
            + solve(y + next_length, x + next_length, next_length)
        )

    return result


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
white, blue = 0, 0

solve(0, 0, n)

print(white)
print(blue)