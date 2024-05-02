import sys

input = sys.stdin.readline


n = int(input())

dp = [0] * 1001
dp[2] = 1

for i in range(5, n + 1):
    for s in [1, 3, 4]:
        if dp[i - s] == 1:
            dp[i] = 0
            break
        dp[i] = 1

print("SK" if dp[n] == 0 else "CY")