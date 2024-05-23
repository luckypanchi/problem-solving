import sys

input = sys.stdin.readline


def solve(full, half):
    if full < 0 or half < 0:
        return 0

    if full == 0 and half == 0:
        return 1

    if dp[full][half] != -1:
        return dp[full][half]

    dp[full][half] = solve(full - 1, half + 1) + solve(full, half - 1)

    return dp[full][half]


dp = [[-1] * 61 for _ in range(31)]


while True:
    n = int(input())
    if n == 0:
        break

    print(solve(n, 0))