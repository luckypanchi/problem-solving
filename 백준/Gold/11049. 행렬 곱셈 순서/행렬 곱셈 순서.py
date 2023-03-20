import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]

for length in range(1, n):
    for start in range(n - length):
        end = start + length
        if length == 1:
            dp[start][end] = matrix[start][0] * matrix[start][1] * matrix[end][1]
            continue

        dp[start][end] = INF
        for k in range(start, end):
            dp[start][end] = min(
                dp[start][end],
                dp[start][k]
                + dp[k + 1][end]
                + matrix[start][0] * matrix[k][1] * matrix[end][1],
            )


print(dp[0][n - 1])