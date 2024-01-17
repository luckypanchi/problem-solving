import sys

input = sys.stdin.readline


n, m, k = map(int, input().split())

dp = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(n + 1):
    dp[0][i] = 1
    dp[i][0] = 1

for i in range(1, n + 1):
    for j in range(1, n + 1):
        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]

answer = ""
for i in range(n, 0, -1):
    if k <= dp[i - 1][m]:
        answer += "0"
    else:
        answer += "1"
        k -= dp[i - 1][m]
        m -= 1

print(answer)