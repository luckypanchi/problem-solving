import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
dp = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, m):
    dp[0][i] += dp[0][i - 1]

for i in range(1, n):
    row_dp = [[0, 0] for _ in range(m)]

    row_dp[0][0] = dp[i][0] + dp[i - 1][0]
    row_dp[-1][1] = dp[i][-1] + dp[i - 1][-1]

    for j in range(1, m):
        row_dp[j][0] = dp[i][j] + max(dp[i - 1][j], row_dp[j - 1][0])

    for j in range(m - 2, -1, -1):
        row_dp[j][1] = dp[i][j] + max(dp[i - 1][j], row_dp[j + 1][1])

    for j in range(m):
        dp[i][j] = max(row_dp[j])

print(dp[n - 1][m - 1])