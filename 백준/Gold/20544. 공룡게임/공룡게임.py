import sys

input = sys.stdin.readline

MOD = 1000000007


def solve(curr, prevHeight, currHeight, isIncluded):
    if curr == n - 1:
        return isIncluded

    if dp[curr][prevHeight][currHeight][isIncluded] != -1:
        return dp[curr][prevHeight][currHeight][isIncluded]

    result = 0
    if currHeight == 0:
        result += solve(curr + 1, currHeight, 0, isIncluded)
        result += solve(curr + 1, currHeight, 1, isIncluded)
        result += solve(curr + 1, currHeight, 2, 1)
    elif currHeight == 1:
        if prevHeight == 0:
            result += solve(curr + 1, currHeight, 0, isIncluded)
            result += solve(curr + 1, currHeight, 1, isIncluded)
            result += solve(curr + 1, currHeight, 2, 1)
        else:
            result += solve(curr + 1, currHeight, 0, isIncluded)
    elif currHeight == 2:
        if prevHeight == 0:
            result += solve(curr + 1, currHeight, 0, isIncluded)
            result += solve(curr + 1, currHeight, 1, isIncluded)
        else:
            result += solve(curr + 1, currHeight, 0, isIncluded)

    dp[curr][prevHeight][currHeight][isIncluded] = result % MOD
    return dp[curr][prevHeight][currHeight][isIncluded]


n = int(input())
dp = [[[[-1] * 2 for _ in range(3)] for _ in range(3)] for _ in range(n)]

print(solve(0, 0, 0, 0))
