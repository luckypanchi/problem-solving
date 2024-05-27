import sys

input = sys.stdin.readline


n = int(input())

t = [0]
p = [0]
for _ in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)

dp = [0] * (n + 2)
for day in range(1, n + 1):
    if day + 1 < n + 2:
        dp[day + 1] = max(dp[day + 1], dp[day])
    if day + t[day] < n + 2:
        dp[day + t[day]] = max(dp[day + t[day]], dp[day] + p[day])

print(dp[-1])