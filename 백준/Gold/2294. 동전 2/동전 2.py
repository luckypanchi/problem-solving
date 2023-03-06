import sys

input = sys.stdin.readline

INF = float("inf")


n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
dp = [INF] * 100001
dp[0] = 1

for c in coins:
    dp[c] = 1
    for i in range(c, k + 1):
        dp[i] = min(dp[i], dp[i - c] + dp[c])

answer = dp[k] if dp[k] != INF else -1
print(answer)