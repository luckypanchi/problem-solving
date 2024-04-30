import sys
from math import comb

input = sys.stdin.readline

MOD = 1000000003


def solve(r, c):
    if c == 1:
        return r

    if r < 2 * c:
        return 0

    if dp[r][c] != -1:
        return dp[r][c]

    dp[r][c] = (solve(r - 1, c) + solve(r - 2, c - 1)) % MOD

    return dp[r][c]


n = int(input())
k = int(input())

dp = [[-1] * 1001 for _ in range(1001)]

answer = solve(n, k)

print(answer)