import sys

input = sys.stdin.readline


def check(y, x, length):
    pivot = board[y][x]

    for i in range(y, y + length):
        for j in range(x, x + length):
            if pivot != board[i][j]:
                return -1

    return pivot


def solve(y, x, length):
    if length == 1:
        return str(board[y][x])

    res = check(y, x, length)
    if res != -1:
        return str(res)

    result = "("
    nlen = length // 2
    result += solve(y, x, nlen)
    result += solve(y, x + nlen, nlen)
    result += solve(y + nlen, x, nlen)
    result += solve(y + nlen, x + nlen, nlen)
    result += ")"

    return result


n = int(input())
board = [list(map(int, input().strip())) for _ in range(n)]

answer = solve(0, 0, n)

print(answer)