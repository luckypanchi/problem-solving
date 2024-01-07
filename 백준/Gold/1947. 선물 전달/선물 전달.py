import sys

input = sys.stdin.readline

MOD = 1000000000


n = int(input())
dp = [0] * max(3, n + 1)
dp[2] = 1
for i in range(3, n + 1):
    dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD

print(dp[n])