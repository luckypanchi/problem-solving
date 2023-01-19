import sys

input = sys.stdin.readline

n, k = map(int, input().split())

w = [0]
v = [0]

for _ in range(n):
    _w, _v = map(int, input().split())
    w.append(_w)
    v.append(_v)

dp = [[0] * (k + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, k + 1):
        if w[i] <= j:
            dp[i][j] = max(dp[i - 1][j], v[i] + dp[i - 1][j - w[i]])
        else:
            dp[i][j] = dp[i - 1][j]

print(dp[n][k])
