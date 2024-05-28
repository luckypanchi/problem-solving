import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))

dp = [[5001] * n for _ in range(n)]

for i in range(n):
    dp[i][i] = 0

for i in range(n - 1):
    if numbers[i] != numbers[i + 1]:
        dp[i][i + 1] = 1
    else:
        dp[i][i + 1] = 0

for length in range(3, n + 1):
    for start in range(n - length + 1):
        end = start + length - 1
        if numbers[start] == numbers[end]:
            dp[start][end] = dp[start + 1][end - 1]
        else:
            dp[start][end] = min(dp[start + 1][end], dp[start][end - 1]) + 1

print(dp[0][n - 1])