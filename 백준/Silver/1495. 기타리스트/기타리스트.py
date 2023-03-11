import sys

input = sys.stdin.readline


n, s, m = map(int, input().split())
volumes = list(map(int, input().split()))

dp = [[False] * (m + 1) for _ in range(n + 1)]
dp[0][s] = True

for i in range(1, n + 1):
    for j in range(m + 1):
        v = volumes[i - 1]
        if dp[i - 1][j] is True:
            if j + v <= m:
                dp[i][j + v] = True
            if 0 <= j - v:
                dp[i][j - v] = True

answer = -1
for i in range(m, -1, -1):
    if dp[n][i] is True:
        answer = i
        break

print(answer)