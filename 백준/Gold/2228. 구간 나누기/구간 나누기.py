import sys

input = sys.stdin.readline
INF = float("inf")


n, m = map(int, input().split())
dp = [[[0] * 2] + [[-INF] * 2 for _ in range(m)] for _ in range(n + 1)]


for i in range(1, n + 1):
    num = int(input())
    for j in range(1, min(m, (i + 1) // 2) + 1):
        dp[i][j][0] = max(dp[i - 1][j])
        dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0]) + num

print(max(dp[n][m]))