import sys

input = sys.stdin.readline


n = int(input())
snacks = [int(input()) for _ in range(n)]
dp = snacks[:]

answer = -1

for i in range(n):
    for j in range(i):
        if snacks[j] < snacks[i] and dp[i] < dp[j] + snacks[i]:
            dp[i] = dp[j] + snacks[i]
    answer = max(answer, dp[i])

print(answer)
