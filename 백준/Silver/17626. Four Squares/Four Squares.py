import sys

input = sys.stdin.readline


n = int(input())
dp = [0] * (n + 1)
dp[1] = 1

for i in range(2, n + 1):
    m = 1e9
    j = 1
    while j**2 <= i:
        m = min(m, dp[i - j**2])
        j += 1
    dp[i] = m + 1

print(dp[n])
