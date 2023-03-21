import sys

input = sys.stdin.readline

length = 1000000
dp = [0] * (length + 1)
dp[1] = 1
dp[2] = 2
dp[3] = 4
for i in range(4, length + 1):
    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009


tc = int(input())
for _ in range(tc):
    n = int(input())
    print(dp[n])