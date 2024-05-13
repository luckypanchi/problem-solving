import sys

input = sys.stdin.readline


def solve(start):
    if start == n:
        return 0

    if dp[start] != -1:
        return dp[start]

    result = 0
    for nextDay in range(start, n):
        t, p = consults[nextDay]
        if nextDay + t - 1 < n:
            result = max(result, p + solve(nextDay + t))

    dp[start] = result
    return dp[start]


n = int(input())
consults = [list(map(int, input().split())) for _ in range(n)]
dp = [-1] * n

print(solve(0))