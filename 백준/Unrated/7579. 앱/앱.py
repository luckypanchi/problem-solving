import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
memory = [0] + list(map(int, input().split()))
cost = [0] + list(map(int, input().split()))

if m == 0:
    print(0)
    sys.exit(0)

max_cost = sum(cost)
dp = [[0] * (max_cost + 1) for _ in range(n + 1)]

answer = INF

for i in range(n + 1):
    for j in range(max_cost + 1):
        if j < cost[i]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i])

        if m <= dp[i][j]:
            answer = min(answer, j)

print(answer)