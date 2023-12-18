import sys

input = sys.stdin.readline
MOD = 1000000007


n, left, right = map(int, input().split())
dp = [[[0] * (right + 1) for _ in range(left + 1)] for _ in range(n + 1)]

dp[1][1][1] = 1
for i in range(2, n + 1):
    for j in range(1, left + 1):
        for k in range(1, right + 1):
            dp[i][j][k] = dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] + dp[i - 1][j][k] * (i - 2)
            dp[i][j][k] %= MOD

print(dp[n][left][right])