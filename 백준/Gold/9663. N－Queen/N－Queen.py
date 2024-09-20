import sys

input = sys.stdin.readline


def mark(row, col, bool):
    col_check[col] = bool
    daegak1_check[row + col] = bool
    daegak2_check[n + row - col] = bool


def solve(curr_row):
    global answer
    if curr_row == n:
        answer += 1
        return

    for col in range(n):
        if (
            not col_check[col]
            and not daegak1_check[curr_row + col]
            and not daegak2_check[n + curr_row - col]
        ):
            mark(curr_row, col, True)
            solve(curr_row + 1)
            mark(curr_row, col, False)


n = int(input())
col_check = [False] * n
daegak1_check = [False] * (2 * n + 1)
daegak2_check = [False] * (2 * n + 1)

answer = 0

solve(0)

print(answer)