import sys

input = sys.stdin.readline


n = int(input())
stones = [0] + list(map(int, input().split()))

dp = [0, 0] + [float("INF")] * (n - 1)

for i in range(2, n + 1):
    for j in range(1, i):
        p = max(dp[j], (i - j) * (1 + abs(stones[i] - stones[j])))
        dp[i] = min(dp[i], p)

print(dp[-1])
