import sys

input = sys.stdin.readline


n = int(input())
board = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]
dp = [[[0] * 3 for _ in range(n + 1)] for _ in range(n + 1)]
dp[1][2][0] = 1

for i in range(1, n + 1):
    for j in range(3, n + 1):
        if board[i][j] == 0:
            dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
            dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            if board[i][j - 1] == 0 and board[i - 1][j] == 0:
                dp[i][j][2] = sum(dp[i - 1][j - 1])


print(sum(dp[n][n]))