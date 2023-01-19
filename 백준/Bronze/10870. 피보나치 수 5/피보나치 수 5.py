import sys

input = sys.stdin.readline


n = int(input())

dp = [0] * (n + 1)

if 0 < n:
    dp[1] = 1

if 1 < n:
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

print(dp[n])
