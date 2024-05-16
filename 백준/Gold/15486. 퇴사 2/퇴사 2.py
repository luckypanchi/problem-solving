import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


INF = float("inf")


def solve(curr):
    if curr > n:
        return -INF

    if curr == n:
        return 0

    if dp[curr] != -1:
        return dp[curr]

    dp[curr] = max(solve(curr + 1), solve(curr + consults[curr][0]) + consults[curr][1])

    return dp[curr]


n = int(input())
consults = [list(map(int, input().split())) for _ in range(n)]
dp = [-1] * n

print(solve(0))