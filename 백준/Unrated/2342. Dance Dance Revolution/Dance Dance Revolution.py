import sys

input = sys.stdin.readline

INF = int(1e9)


def dist(prev, curr):
    if prev == 0:
        return 2
    elif prev == curr:
        return 1
    elif abs(prev % 4 - curr % 4) == 2:
        return 4
    else:
        return 3


moves = list(map(int, input().split()))[:-1]
n = len(moves)

dp = [[[INF] * 5 for _ in range(5)] for _ in range(n + 1)]

dp[0][0][0] = 0

for i in range(1, n + 1):
    m = moves[i - 1]
    for left in range(5):
        for right in range(5):
            dp[i][m][right] = min(
                dp[i][m][right], dp[i - 1][left][right] + dist(left, m)
            )
            dp[i][left][m] = min(
                dp[i][left][m], dp[i - 1][left][right] + dist(right, m)
            )

answer = INF
for left in range(5):
    for right in range(5):
        answer = min(answer, dp[n][left][right])

print(answer)