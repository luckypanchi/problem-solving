import sys

input = sys.stdin.readline


INF = float("inf")

n = int(input())
costs = [list(map(int, input().split())) for _ in range(n)]

answer = INF

for i in range(3):
    dp = [[INF] * 3 for _ in range(n)]

    dp[0][i] = costs[0][i]

    for t in range(1, n):
        dp[t][0] = costs[t][0] + min(dp[t - 1][1], dp[t - 1][2])
        dp[t][1] = costs[t][1] + min(dp[t - 1][2], dp[t - 1][0])
        dp[t][2] = costs[t][2] + min(dp[t - 1][0], dp[t - 1][1])

    for k in range(3):
        if i != k:
            answer = min(answer, dp[n - 1][k])

print(answer)