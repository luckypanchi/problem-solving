import sys

input = sys.stdin.readline

MOD = 100000


def checkRange(y, x):
    return 0 <= y < h and 0 <= x < w


def solve(y, x, isVerticalTurn, isHorizontalTurn, isVerticalMove):
    if not checkRange(y, x):
        return 0

    if (y, x) == (h - 1, w - 1):
        return 1

    if dp[y][x][int(isVerticalTurn)][int(isHorizontalTurn)][int(isVerticalMove)] != -1:
        return dp[y][x][int(isVerticalTurn)][int(isHorizontalTurn)][int(isVerticalMove)]

    result = 0

    if not isVerticalTurn and not isHorizontalTurn:
        if isVerticalMove:
            result += solve(y, x + 1, False, False, True)
            result += solve(y + 1, x, False, True, False)
        else:
            result += solve(y, x + 1, True, False, True)
            result += solve(y + 1, x, False, False, False)
    elif not isVerticalTurn and isHorizontalTurn:
        result += solve(y + 1, x, False, False, False)
    elif isVerticalTurn and not isHorizontalTurn:
        result += solve(y, x + 1, False, False, True)

    dp[y][x][int(isVerticalTurn)][int(isHorizontalTurn)][int(isVerticalMove)] = result % MOD
    return dp[y][x][int(isVerticalTurn)][int(isHorizontalTurn)][int(isVerticalMove)]


w, h = map(int, input().split())
dp = [[[[[-1] * 2 for _ in range(2)] for _ in range(2)] for _ in range(w)] for _ in range(h)]
answer = (solve(0, 1, False, False, True) + solve(1, 0, False, False, False)) % MOD

print(answer)