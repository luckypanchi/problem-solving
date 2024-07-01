import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    n, k = map(int, input().split())
    dp = [[[0] * 2 for _ in range(k + 1)] for _ in range(n + 1)]
    dp[1][0][0] = 1
    dp[1][0][1] = 1

    for i in range(2, n + 1):
        for j in range(min(i, k + 1)):
            if j == 0:
                dp[i][j][0] += dp[i - 1][j][0] + dp[i - 1][j][1]
                dp[i][j][1] += dp[i - 1][j][0]
            else:
                dp[i][j][0] += dp[i - 1][j][0] + dp[i - 1][j][1]
                dp[i][j][1] += dp[i - 1][j][0] + dp[i - 1][j - 1][1]

    print(sum(dp[n][k]))