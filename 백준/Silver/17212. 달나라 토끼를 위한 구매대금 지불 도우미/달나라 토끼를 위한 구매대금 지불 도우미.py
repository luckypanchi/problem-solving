import sys

input = sys.stdin.readline


n = int(input())
dp = [0] * 100001

for i in [1, 2, 5, 7]:
    dp[i] = 1

for i in [3, 4, 6]:
    dp[i] = 2

for i in range(8, 100001):
    dp[i] = min(dp[i - 1] + 1, dp[i - 2] + 1, dp[i - 5] + 1, dp[i - 7] + 1)

print(dp[n])